package com.daust.aeme_backend.report.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class report {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String reportType;
    private LocalDateTime reportDate;
    private String reportLocation;
    private reportStatus reportStatus;
    private String reportDesc;
    private String fileName;
    private String filePath;
    private String contentType;

    //Empty constructor for JPA
    public report(){}

    public report(String reportType, LocalDateTime reportDate, String reportLocation, reportStatus reportStatus, String reportDesc, String fileName, String filePath, String contentType){
        this.reportType = reportType;
        this.reportDate = reportDate;
        this.reportLocation = reportLocation;
        this.reportStatus = reportStatus;
        this.reportDesc = reportDesc;
        this.fileName = fileName;
        this.filePath = filePath;
        this.contentType = contentType;
    }

    public void setReportType(String reportType){
        this.reportType = reportType;
    }
    public String getReportType(){
        return reportType;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }
    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public void setReportLocation(String reportLocation) {
        this.reportLocation = reportLocation;
    }
    public String getReportLocation() {
        return reportLocation;
    }

    public void setReportStatus(reportStatus reportStatus) {
        this.reportStatus = reportStatus;
    }
    public reportStatus getReportStatus() {
        return reportStatus;
    }

    public void setReportDesc(String reportDesc) {
        this.reportDesc = reportDesc;
    }
    public String getReportDesc() {
        return reportDesc;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath() {
        return filePath;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    public String getContentType() {
        return contentType;
    }
}
