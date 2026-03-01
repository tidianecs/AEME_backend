package com.daust.aeme_backend.report.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.daust.aeme_backend.report.model.report;
import com.daust.aeme_backend.report.model.reportStatus;
import com.daust.aeme_backend.report.service.reportService;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/reports")
public class reportController {
    private final reportService service;

    public reportController(reportService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<report> create(
            @RequestParam("reportType") String reportType,
            @RequestParam("reportLocation") String reportLocation,
            @RequestParam("reportStatus") reportStatus reportStatus,
            @RequestParam("reportDesc") String reportDesc,
            @RequestParam("file") MultipartFile file
    ) throws IOException {

        report savedReport = service.createReport(
                reportType,
                reportLocation,
                reportStatus,
                reportDesc,
                file
        );

        return ResponseEntity.ok(savedReport);
    }
}