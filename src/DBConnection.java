import java.sql.Connection;
import java.sql.DriverManager;

/*
 * This class creates a connection between
 * Java application and MySQL database
 */
public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Returns MySQL connection
    public static Connection getConnection() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
