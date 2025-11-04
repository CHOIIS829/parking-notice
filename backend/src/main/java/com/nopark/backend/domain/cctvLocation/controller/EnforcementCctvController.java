package com.nopark.backend.domain.cctvLocation.controller;

import com.nopark.backend.domain.cctvLocation.service.EnforcementCctvService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnforcementCctvController {

    private final EnforcementCctvService enforcementCctvService;

    @GetMapping("/api/enforcement-cctv/fetch" )
    public String fetchCctvData() {
        enforcementCctvService.fetchCctvData();
        return "CCTV data fetch initiated.";
    }
}
