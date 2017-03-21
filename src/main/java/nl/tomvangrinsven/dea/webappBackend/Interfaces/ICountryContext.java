package nl.tomvangrinsven.dea.webappBackend.Interfaces;

import nl.tomvangrinsven.dea.webappBackend.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryContext {
    List<Country> getAllCountries() throws SQLException;
    Country getCountryByID() throws SQLException;
    boolean updateCountry(String name, Country country) throws SQLException;
    boolean deleteCountry(String name) throws SQLException;
    boolean insertCountry(Country country) throws SQLException;


}
