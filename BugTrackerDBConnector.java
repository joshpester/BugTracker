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
                addUser(bugTrackerDBConn, "Tom", "Callin", "User");
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

    public static void addDefect(Connection conn, String DefectName, String DefectDescription, int createdBy, int assignedTo, String status){
        try{
            //Create a statement from the connection
            Statement statement = conn.createStatement();

            //Create sql statement
            String sql = "INSERT INTO Defects(DefectName, DefectDescription, DefectDateTime, CreatedBy, "
                         + "AssignedTo, DefectStatus) " + "VALUES ('" + DefectName + "', '" + DefectDescription
                         + "', NOW(), " + createdBy + ", " + assignedTo + ", '" + status + "');";

            //Insert row into Defects table based on sql statement
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        }
    }

    public static void deleteDefect(Connection conn, int defectNumber){
        try{
            //Create a statement from the connection
            Statement statement = conn.createStatement();

            //Delete data into Defects table
            statement.executeUpdate("DELETE FROM Defects WHERE DefectID = " + defectNumber + ";");
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        }
    }

    public static void updateDefect(Connection conn, String columnName, Object newValue, int defectNumber){
        try{
            //Create a statement from the connection
            Statement statement = conn.createStatement();

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
        }
    }

    public static void addUser(Connection conn, String firstName, String lastName, String userRole){
        try{
            //Create a statement from the connection
            Statement statement = conn.createStatement();

            //Create sql statement
            String sql = "INSERT INTO Users(FirstName, LastName, UserRole) " + 
                         "VALUES ('" + firstName + "', '" + lastName + "', '" + userRole + "');";

            //Insert row into Defects table based on sql statement
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        }
    }

    public static void deleteUser(Connection conn, int userID){
        try{
            //Create a statement from the connection
            Statement statement = conn.createStatement();

            //Delete data into Defects table
            statement.executeUpdate("DELETE FROM Users WHERE UserID = " + userID + ";");
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        }
    }

    public static void updateUser(Connection conn, String columnName, String newValue, int userID){
        try{
            //Create a statement from the connection
            Statement statement = conn.createStatement();

            //Create SQL statement
            String sql = ("UPDATE Users SET " + columnName + " = " + newValue + " WHERE UserID = " + userID + ";");

            // Update table with SQL statement
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Error inserting data");
            ex.printStackTrace();
        }
    }

}
