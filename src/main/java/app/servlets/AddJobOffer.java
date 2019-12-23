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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddJobOffer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        JobOffer jobOffer = new JobOffer();
        try {
            jobOffer.setDesiredFinishTime(dateFormat.parse(request.getParameter("desiredFinishTime")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            jobOffer.setDesiredStartTime(dateFormat.parse(request.getParameter("desiredStartTime")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jobOffer.setDesiredWage(new BigDecimal(request.getParameter("desiredWage")));
        HttpSession mysession = request.getSession();
        jobOffer.setEmployer((Long) mysession.getAttribute("id"));
        jobOffer.setPlacementDate(new Date());
        jobOffer.setRequirements(new String(request.getParameter("requirements").getBytes("ISO-8859-1"), "UTF-8"));
        jobOffer.setOther(new String(request.getParameter("other").getBytes("ISO-8859-1"), "UTF-8"));
        jobOfferServices.create(jobOffer.getEmployerId(), jobOffer.getDesiredStartTime(), jobOffer.getDesiredFinishTime(), jobOffer.getDesiredWage(),
                jobOffer.getPlacementDate(), jobOffer.getRequirements(), jobOffer.getOther());
        response.sendRedirect("/joboffer");
    }
    JobOfferServices jobOfferServices = new JobOfferServices();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("employer")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/addjoboffer.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
