package com.BugTrackerDB;

import java.sql.Blob;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Defect {
    
    private int defectID;
    private String defectName;
    private String defectDescription;
    private LocalDateTime defectDateTime;
    private String defectStatus;
    private Blob defectAttachments;
    private int createdBy;
    private int assignedTo;

    //JSON constructor without DefectID
    //Used for creating new defect
    @JsonCreator
    public Defect(@JsonProperty("defectName") String defectName, @JsonProperty("defectDescription") String defectDescription,
    @JsonProperty("defectStatus") String defectStatus, @JsonProperty("defectAttachments") Blob defectAttachments, 
    @JsonProperty("createdBy") int createdBy, @JsonProperty("assignedTo") int assignedTo) {
        this.defectID = 0;
        this.defectName = defectName;
        this.defectDescription = defectDescription;
        this.defectDateTime = LocalDateTime.now();
        this.defectStatus = defectStatus;
        this.defectAttachments = defectAttachments;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
    }

    //JSON constructor with DefectID
    //Used for editting existing defects
    @JsonCreator
    public Defect(@JsonProperty("defectID") int defectID, @JsonProperty("defectName") String defectName, @JsonProperty("defectDescription") String defectDescription,
    @JsonProperty("defectStatus") String defectStatus, @JsonProperty("defectAttachments") Blob defectAttachments, 
    @JsonProperty("createdBy") int createdBy, @JsonProperty ("assignedTo") int assignedTo) {
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
