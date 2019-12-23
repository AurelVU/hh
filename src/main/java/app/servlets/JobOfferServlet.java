package app.servlets;

import app.domain.JobOffer;
import app.service.JobOfferServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobOfferServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    JobOfferServices jobOfferServices = new JobOfferServices();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JobOffer> jobOffers = jobOfferServices.getAll();
        String str = "";
        for (JobOffer u : jobOffers)
        {
            str += "<tr><td>" + u.getId().toString() + "</td><td>" +
                    u.getOther() + "</td><td>" +
                    u.getRequirements() + "</td><td>" +
                    u.getDesiredStartTime() + "</td><td>" +
                    u.getDesiredFinishTime() + "</td><td>" +
                    u.getDesiredWage() + "</td></td>" +
                    u.getEmployerId() + "</td><td>" +
                    u.getPlacementDate() + "</td></tr>";

        }
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("employer")) {
            req.setAttribute("button", "<button type=\"button\" onclick=\"location.href = '/addjoboffer'\" class=\"btn btn-outline-primary ml-1\">Добавить</button>");
        }
        req.setAttribute("cont", str);
        req.setAttribute("joboffer", "active");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/joboffer.jsp");
        requestDispatcher.forward(req, resp);
    }
}
