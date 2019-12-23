package app.servlets;

import app.domain.Employer;
import app.domain.User;
import app.service.EmoloyerServices;
import app.service.EmploymentServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    EmoloyerServices emoloyerServices = new EmoloyerServices();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employer> employers = emoloyerServices.getAll();
        List<String> logins = new ArrayList<>();
        List<Integer> rating = new ArrayList<>();
        List<String> aboutEmployee = new ArrayList<>();
        List<String> lineActivity = new ArrayList<>();
        String str = "";
        for (Employer e : employers)
        {
            str += "<tr><td>" + e.getId().toString() + "</td><td>" +
                    e.getLogin() + "</td><td>" +
                    e.getRating() + "</td><td>" +
                    e.getAboutCompany() + "</td><td>" +
                    e.getLineActivity() + "</td></tr>";
        }
        request.setAttribute("cont", str);
        request.setAttribute("employer", "active");
       /* req.setAttribute("login", logins);
        req.setAttribute("rating", rating);
        req.setAttribute("aboutEmployee", aboutEmployee);
        req.setAttribute("lineActivity", lineActivity);
*/
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/employer.jsp");
        requestDispatcher.forward(request, response);
    }
}
