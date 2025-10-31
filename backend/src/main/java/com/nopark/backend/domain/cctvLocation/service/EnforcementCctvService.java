package com.nopark.backend.domain.cctvLocation.service;

import com.nopark.backend.domain.cctvLocation.repository.EnforcementCctvRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        String requestUrl = String.format("%s/%s/json/TbOpendataFixedcctv/1/1000/", url, apiKey);

        

    }

}
