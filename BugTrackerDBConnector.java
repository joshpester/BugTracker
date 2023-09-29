import java.sql.*;

public class BugTrackerDBConnector {
    
    public static void main(String[] args) {
        Connection bugTrackerDBConn = null;

        try {
            //Set connection url, username, and password
            String url = "jdbc:mysql://localhost:3306/BugTrackerDB";
            String username = "root";
            String password = "Pest2386!";

            //Create connection
            bugTrackerDBConn = DriverManager.getConnection(url, username, password);

            if(bugTrackerDBConn != null) {
                System.out.println("Connected to the database BugTrackerDB");
                // addDefect(conn, "Add Test", "Test on new add Defect method", 1, 2, "Open");
                // deleteDefect(conn, 4);
                // updateDefect(bugTrackerDBConn, "DefectStatus", "Closed", 6);
                // addUser(bugTrackerDBConn, "Tom", "Callin", "User");
                // System.out.println(getDefectValue(bugTrackerDBConn, "DefectName", 1));
                ResultSet joshDefects = getUserDefects(bugTrackerDBConn, 1);
            }
        } catch (SQLException ex) {
            System.out.println("Error occurred");
            ex.printStackTrace();
        } finally {
            if(bugTrackerDBConn != null) {
                try {
                    bugTrackerDBConn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static ResultSet getUserDefects(Connection conn, int userID){
        //Create statement and resultset
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Create sql query
            String sql = "SELECT * FROM Defects WHERE CreatedBy = " + userID + ";";

            //Add the values to the result set
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while(resultSet.next()){
                for(int i = 1; i <= columnCount; i++){
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(i);

                    System.out.println(columnName + " : " + columnValue);
                }

                System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println("Error occurred");
            ex.printStackTrace();
        } finally {
            if (conn != null){
                try{
                    statement.close();
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultSet;
    }

    public static Object getDefectValue(Connection conn, String columnName, int defectNumber){
        //Create statement and resultset
        Statement statement = null;
        ResultSet resultSet = null;
        Object result = null;

        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Create sql statement
            String sql = "SELECT " + columnName + " FROM Defects WHERE DefectID = " + defectNumber + ";";

            //Set result set equal to the value returned from executing the sql query
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                result = resultSet.getString(columnName);
            }
        } catch (SQLException ex) {
            System.out.println("Error occurred");
            ex.printStackTrace();
        } finally {
            if(conn != null){
                try {
                    statement.close();
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return result;
    }

    public static void addDefect(Connection conn, String DefectName, String DefectDescription, int createdBy, int assignedTo, String status){
        //Create statement
        Statement statement = null;

        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Create sql statement
            String sql = "INSERT INTO Defects(DefectName, DefectDescription, DefectDateTime, CreatedBy, "
                         + "AssignedTo, DefectStatus) " + "VALUES ('" + DefectName + "', '" + DefectDescription
                         + "', NOW(), " + createdBy + ", " + assignedTo + ", '" + status + "');";

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

    public static void deleteDefect(Connection conn, int defectNumber){
        //Create statement
        Statement statement = null;
        
        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Delete data into Defects table
            statement.executeUpdate("DELETE FROM Defects WHERE DefectID = " + defectNumber + ";");
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

    public static void updateDefect(Connection conn, String columnName, Object newValue, int defectNumber){
        //Create statement
        Statement statement = null;
        
        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Create SQL statement
            String sql = ("UPDATE Defects SET " + columnName + " = ");
            if(newValue instanceof String) {
                sql +=  "'" + newValue.toString() + "'";
            } else {
                sql += newValue; 
            }
            sql += " WHERE DefectID = " + defectNumber + ";";

            // Update table with SQL statement
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

    public static void addUser(Connection conn, String firstName, String lastName, String userRole){
        //Create statement
        Statement statement = null;
        
        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Create sql statement
            String sql = "INSERT INTO Users(FirstName, LastName, UserRole) " + 
                         "VALUES ('" + firstName + "', '" + lastName + "', '" + userRole + "');";

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

    public static void deleteUser(Connection conn, int userID){
        //Create statement
        Statement statement = null;
        
        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Delete data into Defects table
            statement.executeUpdate("DELETE FROM Users WHERE UserID = " + userID + ";");
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

    public static void updateUser(Connection conn, String columnName, String newValue, int userID){
        //Create statement
        Statement statement = null;
        
        try{
            //Initialize statement from the connection
            statement = conn.createStatement();

            //Create SQL statement
            String sql = ("UPDATE Users SET " + columnName + " = " + newValue + " WHERE UserID = " + userID + ";");

            // Update table with SQL statement
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
