package com.BugTrackerDB;

import java.sql.*;
import java.util.*;

public class DefectDAO {
    
    public Connection defectsConnection;

    public DefectDAO(Connection defectsConnection) {
        this.defectsConnection = defectsConnection;
    }

    //Returns a List of all the Defects
    public List<Defect> getAllDefects() throws SQLException {
        List<Defect> defects = new ArrayList<>();
        String query = "SELECT * FROM Defects;";
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Defect defect = new Defect(resultSet.getInt(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(5), resultSet.getBlob(6), 
                resultSet.getInt(7), resultSet.getInt(8));
                defects.add(defect);
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return defects;
    }

    //Returns a count of the Defects in the Defects table
    public int getDefectCount() {
        int defectCount = 0;
        String query = "SELECT COUNT(*) FROM Defects;";
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                defectCount = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return defectCount;
    }
    
}
