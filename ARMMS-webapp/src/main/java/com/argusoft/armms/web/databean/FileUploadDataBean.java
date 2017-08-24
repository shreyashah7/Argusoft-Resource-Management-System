/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argusoft.armms.web.databean;

import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.richfaces.model.UploadedFile;

/**
 *
 * @author shreya
 */
@ManagedBean(name = "fileUploadDataBean")
@RequestScoped
public class FileUploadDataBean {

    private String fileName;
    private String filePath;
    private Long fileSize;
    private String fileSizeKb;
    private byte[] fileData;
    private String fileDescription;
    private Long projectId;
    private Date createdOn;
    private String uploadedByName;
    private Long uploadedBy;
    private String projectName;
    private Long projectAttachmentId;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getProjectAttachmentId() {
        return projectAttachmentId;
    }

    public void setProjectAttachmentId(Long projectAttachmentId) {
        this.projectAttachmentId = projectAttachmentId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getFileSizeKb() {
        return fileSizeKb;
    }

    public void setFileSizeKb(String fileSizeKb) {
        this.fileSizeKb = fileSizeKb;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUploadedByName() {
        return uploadedByName;
    }

    public void setUploadedByName(String uploadedByName) {
        this.uploadedByName = uploadedByName;
    }

    public Long getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Long uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

}
