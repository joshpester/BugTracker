package com.BugTrackerDB;

import java.sql.*;

public class UserDAO {
    
    public Connection usersConnection;

    public UserDAO(Connection usersConnection) {
        this.usersConnection = usersConnection;
    }

    

}
