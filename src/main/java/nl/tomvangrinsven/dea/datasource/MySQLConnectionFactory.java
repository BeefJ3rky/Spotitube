package nl.tomvangrinsven.dea.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory {

    private static String username = "root";
    private static String password = "Root123";
    private static String dbUrl = "jdbc:mysql://localhost:3306/spotitube";

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(dbUrl, username, password);
        return conn;
    }
}
