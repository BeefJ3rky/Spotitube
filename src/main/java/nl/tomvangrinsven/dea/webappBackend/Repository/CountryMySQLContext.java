package nl.tomvangrinsven.dea.webappBackend.Repository;

import nl.tomvangrinsven.dea.webappBackend.Country;
import nl.tomvangrinsven.dea.webappBackend.Database.MySQLDatabase;
import nl.tomvangrinsven.dea.webappBackend.Interfaces.ICountryContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryMySQLContext implements ICountryContext {
    Connection conn = null;
    Statement stmt = null;
    String query = null;
    ArrayList<Country> returnList = null;
    Country country = null;
    @Override
    public List<Country> getAllCountries() throws SQLException{

        returnList = new ArrayList<>();
        try {
            conn = MySQLDatabase.getConnection();
            Statement stmt = conn.createStatement();
            String query = "select Code, Name from Country";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                returnList.add(new Country(rs.getString("Code"), rs.getString("Name")));
            }
        }
        catch (SQLException e){e.printStackTrace();}
        finally {closeConnection(conn);}
        return returnList;
    }

    @Override
    public Country getCountryByID() throws SQLException {
        conn = MySQLDatabase.getConnection();
        Statement stmt = conn.createStatement();
        String query = "select Code, Name from Country";
        ResultSet rs = stmt.executeQuery(query);
        try {country = new Country(rs.getString("Code"), rs.getString("Name"));}
        catch (SQLException e){e.printStackTrace();}
        finally {closeConnection(conn);}
        return country;
    }

    public boolean updateCountry(String name, Country country) throws SQLException{
        conn = MySQLDatabase.getConnection();
        PreparedStatement p = conn.prepareStatement("Update Country set Name = ? where Name = ?");
        p.setString(1, name);
        p.setString(2, country.getName());
        if (executeNonQuery(p)){
            closeConnection(conn);
            return true;
        }
        return false;
    }

    public boolean deleteCountry(String name) throws SQLException {
        conn = MySQLDatabase.getConnection();
        PreparedStatement p = conn.prepareStatement("Delete from Country where Name = ?");
        p.setString(1, name);
        if (executeNonQuery(p)){
            closeConnection(conn);
            return true;
        }
        return false;
    }

    public boolean insertCountry(Country country) throws SQLException {
        conn = MySQLDatabase.getConnection();
        PreparedStatement p = conn.prepareStatement("Insert into Country values ?, ?");
        p.setString(1, country.getCode());
        p.setString(2, country.getName());
        if (executeNonQuery(p)){
            closeConnection(conn);
            return true;
        }
        return false;
    }

    public boolean executeNonQuery(PreparedStatement p) throws SQLException{
        try { p.executeUpdate(); return true; }
        catch (SQLException e){e.printStackTrace();}
        return false;
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null){ conn.close();}
    }
}
