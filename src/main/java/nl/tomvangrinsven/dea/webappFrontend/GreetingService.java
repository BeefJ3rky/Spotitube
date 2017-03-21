package nl.tomvangrinsven.dea.webappFrontend;

import nl.tomvangrinsven.dea.webappBackend.*;
import nl.tomvangrinsven.dea.webappBackend.Repository.CountryMySQLContext;
import nl.tomvangrinsven.dea.webappFrontend.Logic.CountryRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/GreetingService")
public class GreetingService extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;chartset=UTF-8");
        PrintWriter out = response.getWriter();

        CountryRepository repo = new CountryRepository(new CountryMySQLContext());

        try {
            for (Country country :
                    repo.getAllCountries()) {
                out.println(country.getName());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }
}
