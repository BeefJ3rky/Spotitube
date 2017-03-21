package nl.tomvangrinsven.dea.webappFrontend.Logic;

import nl.tomvangrinsven.dea.webappBackend.Country;
import nl.tomvangrinsven.dea.webappBackend.Interfaces.ICountryContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tom van Grinsven on 3/14/2017.
 */
public class CountryRepository implements ICountryContext {

    private ICountryContext context;

    public CountryRepository(ICountryContext context) {
        this.context = context;
    }

    @Override
    public List<Country> getAllCountries() throws SQLException {
        return context.getAllCountries();
    }

    @Override
    public Country getCountryByID() throws SQLException {
        return context.getCountryByID();
    }

    @Override
    public boolean updateCountry(String name, Country country) throws SQLException {
        return context.updateCountry(name, country);
    }

    @Override
    public boolean deleteCountry(String name) throws SQLException {
        return context.deleteCountry(name);
    }

    @Override
    public boolean insertCountry(Country country) throws SQLException {
        return context.insertCountry(country);
    }
}
