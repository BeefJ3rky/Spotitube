package nl.tomvangrinsven.dea.webappBackend.Database;

import java.sql.*;

/**
 * Created by Tom van Grinsven on 3/13/2017.
 */
public  class MySQLDatabase {
    private static String username = "root";
    private static String password = "Root123";
    private static String dbUrl = "jdbc:mysql://localhost:3306/world";
    private static Connection conn = null;

    public static Connection getConnection() throws SQLException{

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(dbUrl, username, password);


        return conn;
    }


}
