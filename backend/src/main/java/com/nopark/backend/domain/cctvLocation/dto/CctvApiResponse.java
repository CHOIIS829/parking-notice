package com.nopark.backend.domain.cctvLocation.dto;

import lombok.Data;

import java.util.List;

@Data
public class CctvApiResponse {

    private TbOpendataFixedcctv TbOpendataFixedcctv;

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
            private String FIX_CCTV_ADDR;
            private String LAT;
            private String LOT;
            private String CGG_CD;
            private String CRDN_BRNCH_NM;
            private String GRNDS_SE;
        }
    }
}
