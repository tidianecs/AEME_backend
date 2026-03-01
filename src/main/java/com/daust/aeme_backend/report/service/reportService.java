package com.daust.aeme_backend.report.service;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.daust.aeme_backend.report.model.report;
import com.daust.aeme_backend.report.model.reportStatus;
import com.daust.aeme_backend.report.repository.reportRepository;

@Service
public class reportService {
    private final reportRepository repository;
    private final fileStorageService fileStorageService;

    public reportService(reportRepository repository, fileStorageService fileStorageService) {
        this.repository = repository;
        this.fileStorageService = fileStorageService;
    }

    public report createReport(String reportType, String reportLocation, reportStatus reportStatus, String reportDesc, MultipartFile file) throws IOException {

        String savedFilePath = fileStorageService.saveFile(file);

        report report = new report();
        report.setReportType(reportType);
        report.setReportDate(LocalDateTime.now());
        report.setReportLocation(reportLocation);
        report.setReportStatus(reportStatus);
        report.setReportDesc(reportDesc);
        report.setFileName(file.getOriginalFilename());
        report.setContentType(file.getContentType());
        report.setFilePath(savedFilePath);

        return repository.save(report);
    }
}