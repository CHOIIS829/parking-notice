package com.nopark.backend.domain.test;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Enforcement, Long> {
}
