package nl.tomvangrinsven.dea;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by Tom van Grinsven on 3/20/2017.
 */
public class DatabaseTest {
    MySQLDatabase dbs;
    @Before
    public void setUp(){
        dbs = new MySQLDatabase();
    }

    @Test
    public void testConnection() throws SQLException {
        Connection conn = MySQLDatabase.getConnection();
        assertNotNull(conn);

    }

}
