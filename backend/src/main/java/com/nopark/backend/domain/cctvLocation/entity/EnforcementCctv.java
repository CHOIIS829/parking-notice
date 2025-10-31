package com.nopark.backend.domain.cctvLocation.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class EnforcementCctv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 설치 주소
    @Column(name = "address", length = 255)
    private String address; // FIX_CCTV_ADDR

    // 위도
    @Column(name = "latitude")
    private Double latitude; // LAT

    // 경도
    @Column(name = "longitude")
    private Double longitude; // LOT

    // 자치구 (ex: 양천구)
    @Column(name = "district", length = 50)
    private String district; // CGG_CD

    // CCTV 설치 지점명
    @Column(name = "branch_name", length = 255)
    private String branchName; // CRDN_BRNCH_NM

    // 설치 구분 (불법주정차구역 등)
    @Column(name = "ground_type", length = 100)
    private String groundType; // GRNDS_SE

    @Builder
    public EnforcementCctv(Long id, String address, Double latitude, Double longitude, String district, String branchName, String groundType) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.district = district;
        this.branchName = branchName;
        this.groundType = groundType;
    }
}
