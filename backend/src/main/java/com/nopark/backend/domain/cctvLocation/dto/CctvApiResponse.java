package com.nopark.backend.domain.cctvLocation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CctvApiResponse {

    @JsonProperty("TbOpendataFixedcctv")
    private TbOpendataFixedcctv body;

    @Data
    public static class TbOpendataFixedcctv {
        private Integer list_total_count;
        private Result RESULT;
        private List<Row> row;

        @Data
        public static class Result {
            private String CODE;
            private String MESSAGE;
        }

        @Data
        public static class Row {
            @JsonProperty("FIX_CCTV_ADDR")
            private String FIX_CCTV_ADDR;
            @JsonProperty("LAT")
            private String LAT;
            @JsonProperty("LOT")
            private String LOT;
            @JsonProperty("CGG_CD")
            private String CGG_CD;
            @JsonProperty("CRDN_BRNCH_NM")
            private String CRDN_BRNCH_NM;
            @JsonProperty("GRNDS_SE")
            private String GRNDS_SE;
        }
    }
}
