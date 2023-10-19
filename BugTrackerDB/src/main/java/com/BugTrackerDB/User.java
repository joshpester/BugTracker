package com.BugTrackerDB;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int userID;
    private String userFirstName;
    private String userLastName;
    private String userRole;

    //JSON constructor with userID
    @JsonCreator
    public User(@JsonProperty("userID") int userID, @JsonProperty("userFirstName") String userFirstName,
                @JsonProperty("userLastName") String userLastName, @JsonProperty("userRole") String userRole) {
        this.userID = userID;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userRole = userRole;
     }

     public int getUserID(){
        return userID;
     }

     public void setUserID(int userID){
        this.userID = userID;
     }

     public String getUserFirstName(){
        return userFirstName;
     }

     public void setUserFirstName(String userFirstName){
        this.userFirstName = userFirstName;
     }

     public String getUserLastName(){
        return userLastName;
     }

     public void setUserLastName(String userLastName){
        this.userLastName = userLastName;
     }

     public String getUserRole(){
        return userRole;
     }

     public void setUserRole(String userRole){
        this.userRole = userRole;
     }

}
