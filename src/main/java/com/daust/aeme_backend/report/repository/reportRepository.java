package com.daust.aeme_backend.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.daust.aeme_backend.report.model.report;

public interface reportRepository extends JpaRepository<report, Long> {
}
