package com.nopark.backend.domain.test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enforcement {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rawDate;
    private String rawTime;

    // 위도
    private Double latitude;

    // 경도
    private Double longitude;
}
