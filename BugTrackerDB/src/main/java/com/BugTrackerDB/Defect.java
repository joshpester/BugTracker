package com.BugTrackerDB;

import java.sql.Blob;
import java.time.LocalDateTime;

public class Defect {
    
    private int defectID;
    private String defectName;
    private String defectDescription;
    private LocalDateTime defectDateTime;
    private String defectStatus;
    private Blob defectAttachments;
    private int createdBy;
    private int assignedTo;

    public Defect(int defectID, String defectName, String defectDescription, String defectStatus, Blob defectAttachments, int createdBy, int assignedTo) {
        this.defectID = defectID;
        this.defectName = defectName;
        this.defectDescription = defectDescription;
        this.defectDateTime = LocalDateTime.now();
        this.defectStatus = defectStatus;
        this.defectAttachments = defectAttachments;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
    }

    public int getDefectID() {
        return defectID;
    }

    public void setDefectID(int defectID) {
        this.defectID = defectID;
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    public String getDefectDescription() {
        return defectDescription;
    }

    public void setDefectDescription(String defectDescription) {
        this.defectDescription = defectDescription;
    }

    public LocalDateTime getDefectDateTime() {
        return defectDateTime;
    }

    public String getDefectStatus() {
        return defectStatus;
    }

    public void setDefectStatus(String defectStatus) {
        this.defectStatus = defectStatus;
    }

    public Blob getDefectFile() {
        return defectAttachments;
    }

    public void setDefectID(Blob defectAttachments) {
        this.defectAttachments = defectAttachments;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }
}
