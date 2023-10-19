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
                    resultSet.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return defects;
    }

    //Returns a single Defect
    public Defect getSingleDefect(int defectID) throws SQLException {
        Defect singleDefect = null;
        String query = "SELECT * FROM Defects WHERE DefectID = " + defectID + ";";
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                singleDefect = new Defect(resultSet.getInt(1), resultSet.getString(2), 
                resultSet.getString(3), resultSet.getString(5), resultSet.getBlob(6), 
                resultSet.getInt(7), resultSet.getInt(8));
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                    resultSet.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return singleDefect;
    }

    //Returns a List of the Defect Status counts by User
    public List<UserDefectCounts> getDefectCountsByUser() throws SQLDataException {
        List<UserDefectCounts> defectCountsByUser = new ArrayList<>();
        String query = "SELECT CONCAT(u.FirstName, \" \", u.LastName) AS 'User', " +
                        "SUM(CASE WHEN d.DefectStatus = 'Open' AND u.UserID = d.CreatedBy THEN 1 ELSE 0 END) AS 'Open', " +
                        "SUM(CASE WHEN d.DefectStatus = 'In Progress' AND u.UserID = d.CreatedBy THEN 1 ELSE 0 END) AS 'In Progress', " +
                        "SUM(CASE WHEN d.DefectStatus = 'Closed' AND u.UserID = d.CreatedBy THEN 1 ELSE 0 END) AS 'Closed' " +
                        "FROM Defects d, Users u GROUP BY User;";
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                UserDefectCounts userDefectCounts = new UserDefectCounts(resultSet.getString(1), resultSet.getInt(2), 
                    resultSet.getInt(3), resultSet.getInt(4));
                defectCountsByUser.add(userDefectCounts);
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                    resultSet.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return defectCountsByUser;
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
                    resultSet.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return defectCount;
    }

    //Returns a count of the Open Defects in the Defects table
    public int getOpenDefectCount() {
        int openDefectCount = 0;
        String query = "SELECT COUNT(*) FROM Defects WHERE DefectStatus = \"Open\";";
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                openDefectCount = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                    resultSet.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return openDefectCount;
    }

    //Returns a count of the Defects in the Defects table
    public int getInProgressDefectCount() {
        int inProgressDefectCount = 0;
        String query = "SELECT COUNT(*) FROM Defects WHERE DefectStatus = \"In Progress\";";
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                inProgressDefectCount = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                    resultSet.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return inProgressDefectCount;
    }

    //Returns a count of the Defects in the Defects table
    public int getClosedDefectCount() {
        int closedDefectCount = 0;
        String query = "SELECT COUNT(*) FROM Defects WHERE DefectStatus = \"Closed\";";
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                closedDefectCount = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                    resultSet.close();
                    defectsConnection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return closedDefectCount;
    }
    
    //Adds a new defect passed in from the web to the Defect Table
    public void addDefect(Defect newDefect){
        //Create statement
        Statement statement = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Create sql statement
            String sql = "INSERT INTO Defects(DefectName, DefectDescription, DefectDateTime, CreatedBy, "
                        + "AssignedTo, DefectStatus) " + "VALUES (\"" + newDefect.getDefectName() + "\", \"" + newDefect.getDefectDescription()
                        + "\", NOW(), " + newDefect.getCreatedBy() + ", " + newDefect.getAssignedTo() + ", \"" + newDefect.getDefectStatus() + "\");";

            //Insert row into Defects table based on sql statement
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //Edits a defect based on the edits made in the web
    public void editDefect(Defect edittedDefect){
        //Create statement
        Statement statement = null;

        try{
            //Initialize statement from the connection
            statement = defectsConnection.createStatement();

            //Create sql statement
            String sql = "UPDATE Defects SET DefectName = \"" + edittedDefect.getDefectName() + "\", DefectDescription = \"" 
                        + edittedDefect.getDefectDescription() + "\", CreatedBy = " + edittedDefect.getCreatedBy() + ", AssignedTo = " 
                        + edittedDefect.getAssignedTo() + ", DefectStatus = \"" + edittedDefect.getDefectStatus() + "\" WHERE DefectID = " + edittedDefect.getDefectID() + ";";

            //Edit row in Defects table based on sql statement
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        } finally {
            if(statement != null) {
                try{
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
