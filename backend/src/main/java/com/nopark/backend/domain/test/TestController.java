package com.nopark.backend.domain.test;

import com.nopark.backend.global.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    // Create Enforcement - for testing
    @PostMapping("/test/enforcement")
    public ResponseEntity<SuccessResponse<Void>> createEnforcement(@RequestBody Enforcement enforcement) {
        testService.saveEnforcement(enforcement);

        return ResponseEntity.ok(SuccessResponse.<Void>builder()
                .code("200")
                .message("Enforcement created successfully")
                .build());
    }

    // Get all Enforcements - for testing
    @GetMapping("/test/enforcements")
    public ResponseEntity<SuccessResponse<List>>  getAllEnforcements() {
        List<Enforcement> allEnforcements = testService.getAllEnforcements();

        return ResponseEntity.ok(SuccessResponse.<List>builder()
                .code("200")
                .message("Enforcements retrieved successfully")
                .data(allEnforcements)
                .build());
    }


}
