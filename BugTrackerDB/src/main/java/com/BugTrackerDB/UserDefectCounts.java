package com.BugTrackerDB;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDefectCounts {
    
    private String userName;
    private int openDefectsCount;
    private int inProgressDefectsCount;
    private int closedDefectsCount;

    //JSON Constructor
    @JsonCreator
    public UserDefectCounts(@JsonProperty("userName") String userName, @JsonProperty("openDefectsCount") int openDefectsCount,
                            @JsonProperty("inProgressDefectsCount") int inProgressDefectsCount, @JsonProperty("closedDefectsCount") int closedDefectsCount) {

        this.userName = userName;
        this.openDefectsCount = openDefectsCount;
        this.inProgressDefectsCount = inProgressDefectsCount;
        this.closedDefectsCount = closedDefectsCount;
                        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getOpenDefectsCount() {
        return openDefectsCount;
    }

    public void setUserName(int openDefectsCount) {
        this.openDefectsCount = openDefectsCount;
    }

    public int getInProgressDefectsCount() {
        return inProgressDefectsCount;
    }

    public void setInProgressDefectsCount(int inProgressDefectsCount) {
        this.inProgressDefectsCount = inProgressDefectsCount;
    }

    public int getClosedDefectsCount() {
        return closedDefectsCount;
    }

    public void setClosedDefectsCount(int closedDefectsCount) {
        this.closedDefectsCount = closedDefectsCount;
    }

}
