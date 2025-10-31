package com.nopark.backend.domain.cctvLocation.repository;

import com.nopark.backend.domain.cctvLocation.entity.EnforcementCctv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnforcementCctvRepository extends JpaRepository<EnforcementCctv, Long> {
}
