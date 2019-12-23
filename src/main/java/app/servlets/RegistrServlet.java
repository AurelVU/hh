package app.servlets;

import app.service.EmoloyerServices;
import app.service.UserServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrServlet extends HttpServlet {
    UserServices userServices = new UserServices();
    EmoloyerServices employerServices = new EmoloyerServices();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputLogin");
        String password = req.getParameter("inputPassword");
        String user = req.getParameter("role");
        if (user.equals("user")) {
            if (userServices.registration(name, password))
            {
                HttpSession session = req.getSession();
                session.setAttribute("login", name);
                session.setAttribute("type", user);
                session.setAttribute("id", userServices.getIdByLogin(name));
                resp.sendRedirect("/");
            } else {
                PrintWriter out = resp.getWriter();
                out.println("Пользователь с данным логином уже существует");
            }
        } else
        {
            if (employerServices.registration(name, password))
            {
                HttpSession session = req.getSession();
                session.setAttribute("login", name);
                session.setAttribute("type", user);
                session.setAttribute("id", employerServices.getIdByLogin(name));
                resp.sendRedirect("/");
            } else {
                PrintWriter out = resp.getWriter();
                out.println("Пользователь с данным логином уже существует");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/reg.jsp");
        requestDispatcher.forward(req, resp);
    }
}

