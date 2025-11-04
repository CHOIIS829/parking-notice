package com.nopark.backend.domain.cctvLocation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nopark.backend.domain.cctvLocation.dto.CctvApiResponse;
import com.nopark.backend.domain.cctvLocation.entity.EnforcementCctv;
import com.nopark.backend.domain.cctvLocation.repository.EnforcementCctvRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EnforcementCctvService {

    private final EnforcementCctvRepository enforcementCctvRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${api.key}")
    private String apiKey;
    @Value("${api.url}")
    private String url;

    public void fetchCctvData() {
        // ✅ URL 조합
        String requestUrl = String.format("%s/%s/json/TbOpendataFixedcctv/1/1000/", url, apiKey);
        log.info("[REQUEST] {}", requestUrl);

        try {
            CctvApiResponse response = restTemplate.getForObject(requestUrl, CctvApiResponse.class);
            if (response == null || response.getBody() == null || response.getBody().getRow() == null) {
                String raw = restTemplate.getForObject(requestUrl, String.class);
                if (raw != null) {
                    log.warn("⚠️ No data found from API response, raw response (first 300 chars): {}", raw.length() > 300 ? raw.substring(0, 300) : raw);
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        response = mapper.readValue(raw, CctvApiResponse.class);
                    } catch (Exception ex) {
                        log.error("❌ Failed to parse raw response to CctvApiResponse", ex);
                        return;
                    }
                } else {
                    log.warn("⚠️ No data found and raw response is null");
                    return;
                }
            }
            log.info("[RESPONSE] {}", response);

            List<EnforcementCctv> entities = new ArrayList<>();

            // ✅ DTO → Entity 매핑
            for (CctvApiResponse.TbOpendataFixedcctv.Row r : response.getBody().getRow()) {
                Double lat = parseDoubleSafe(r.getLAT());
                Double lon = parseDoubleSafe(r.getLOT());
                if (lat == null || lon == null) continue;

                EnforcementCctv entity = EnforcementCctv.builder()
                        .address(r.getFIX_CCTV_ADDR())
                        .latitude(lat)
                        .longitude(lon)
                        .district(r.getCGG_CD())
                        .branchName(r.getCRDN_BRNCH_NM())
                        .groundType(r.getGRNDS_SE())
                        .build();

                entities.add(entity);
            }

            enforcementCctvRepository.saveAll(entities);
            log.info("✅ Saved {} CCTV records", entities.size());

        } catch (Exception e) {
            log.error("❌ Failed to fetch CCTV data", e);
        }
    }

    private Double parseDoubleSafe(String s) {
        try {
            if (s == null) return null;
            s = s.trim();
            if (s.isEmpty()) return null;
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
