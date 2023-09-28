import java.sql.*;

public class BugTrackerDBConnector {
    
    public static void main(String[] args) {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/BugTrackerDB";
            String username = "root";
            String password = "Pest2386!";

            conn = DriverManager.getConnection(url, username, password);
            if(conn != null) {
                System.out.println("Connected to the database BugTrackerDB");
                // addDefect(conn, "Add Test", "Test on new add Defect method", 1, 2, "Open");
                // deleteDefect(conn, 4);
                updateDefect(conn, "DefectStatus", "Closed", 6);
            }
        } catch (SQLException ex) {
            System.out.println("Error occurred");
            ex.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
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
            System.out.println(sql);

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

}
