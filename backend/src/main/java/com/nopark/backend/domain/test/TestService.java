package com.nopark.backend.domain.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public Enforcement saveEnforcement(Enforcement enforcement) {
        return testRepository.save(enforcement);
    }

    public java.util.List<Enforcement> getAllEnforcements() {
        return testRepository.findAll();
    }
}
