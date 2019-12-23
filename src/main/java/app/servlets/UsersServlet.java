package app.servlets;

import app.domain.User;
import app.service.UserServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersServlet extends HttpServlet {
    UserServices userServices = new UserServices();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userServices.getAll();
        List<String> logins = new ArrayList<>();
        List<Integer> rating = new ArrayList<>();
        List<String> aboutEmployee = new ArrayList<>();
        List<String> lineActivity = new ArrayList<>();
        String str = "";
        for (User u : users)
        {
            str += "<tr><td>" + u.getId().toString() + "</td><td>" +
                    u.getLogin() + "</td><td>" +
                    u.getRating() + "</td><td>" +
                    u.getAboutEmployee() + "</td><td>" +
                    u.getLineActivity()+ "</td></tr>";
            logins.add(u.getLogin());
            rating.add(u.getRating());
            aboutEmployee.add(u.getAboutEmployee());
            lineActivity.add(u.getLineActivity());
        }
        req.setAttribute("cont", str);
        req.setAttribute("users", "active");
       /* req.setAttribute("login", logins);
        req.setAttribute("rating", rating);
        req.setAttribute("aboutEmployee", aboutEmployee);
        req.setAttribute("lineActivity", lineActivity);
*/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/users.jsp");
        requestDispatcher.forward(req, resp);
    }
}
