package app.servlets;

import app.domain.Employer;
import app.domain.User;
import app.service.EmoloyerServices;
import app.service.EmploymentServices;
import app.service.UserServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.stream.Stream;

public class PersonalArea extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long id = (Long) session.getAttribute("id");
        String login = (String) session.getAttribute("login");
        String role = (String) session.getAttribute("type");
        if(role.equals("user")) {
            User user = userServices.getById(id);
            String password = req.getParameter("password");
            if (!password.equals(""))
                user.setPassword(password);
            user.setAboutEmployee(new String(req.getParameter("aboutEmployee").getBytes("ISO-8859-1"), "UTF-8"));
            user.setLineActivity(new String(req.getParameter("lineActivity").getBytes("ISO-8859-1"), "UTF-8"));
            userServices.change(user.getId(), user.getLogin(), user.getPassword(), user.getRating(), user.getAboutEmployee(), user.getLineActivity());
        } else
        {
            Employer employer = employerServices.getById(id);
            String password = req.getParameter("password");
            if (!password.equals(""))
                employer.setPassword(password);
            employer.setAboutCompany(new String(req.getParameter("aboutCompany").getBytes("ISO-8859-1"), "UTF-8"));
            employer.setLineActivity(new String(req.getParameter("lineActivity").getBytes("ISO-8859-1"), "UTF-8"));
            employerServices.change(employer.getId(), employer.getLogin(), employer.getPassword(), employer.getRating(), employer.getAboutCompany(), employer.getLineActivity());
        }
        resp.sendRedirect("/personalarea");
    }
    UserServices userServices = new UserServices();
    EmoloyerServices employerServices = new EmoloyerServices();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long id = (Long) session.getAttribute("id");
        String role = (String) session.getAttribute("type");
        if (role.equals("user")) {
            User user = userServices.getById(id);
            req.setAttribute("id", user.getId());
            req.setAttribute("role", "user");
            req.setAttribute("login", user.getLogin());
            req.setAttribute("rating", user.getRating());
            req.setAttribute("aboutEmployee", user.getAboutEmployee());
            req.setAttribute("lineActivity", user.getLineActivity());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/personalareauser.jsp");
            requestDispatcher.forward(req, resp);
        } else
        {
            Employer employer = employerServices.getById(id);
            req.setAttribute("id", employer.getId());
            req.setAttribute("role", "employer");
            req.setAttribute("login", employer.getLogin());
            req.setAttribute("rating", employer.getRating());
            req.setAttribute("aboutEmployee", employer.getAboutCompany());
            req.setAttribute("lineActivity", employer.getLineActivity());
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/personalareaemployer.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
