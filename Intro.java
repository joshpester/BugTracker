import java.sql.*;

public class Intro {
    
    public static void main(String[] args) {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/BugTrackerDB";
            String username = "root";
            String password = "Pest2386!";

            conn = DriverManager.getConnection(url, username, password);
            if(conn != null) {
                System.out.println("Connected to the database BugTrackerDB");
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

}
