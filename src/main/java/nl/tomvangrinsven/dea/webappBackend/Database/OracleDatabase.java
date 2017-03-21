package nl.tomvangrinsven.dea.webappBackend.Database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Tom van Grinsven on 3/20/2017.
 */
public class OracleDatabase {
    private static final String username = "hr";
    private static final String password = "hr";
    private static final String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(dbUrl, username, password);

        return conn;
    }
}
