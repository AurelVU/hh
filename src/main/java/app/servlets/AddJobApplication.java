package app.servlets;

import app.domain.JobApplication;
import app.service.JobApplicationServices;

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


public class AddJobApplication extends HttpServlet {
    JobApplicationServices jobApplicationServices = new JobApplicationServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession mysession = request.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("user")) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            JobApplication jobApplication = new JobApplication();
            try {
                jobApplication.setDesiredFinishTime(dateFormat.parse(request.getParameter("desiredFinishTime")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                jobApplication.setDesiredStartTime(dateFormat.parse(request.getParameter("desiredStartTime")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jobApplication.setDesiredWage(new BigDecimal(request.getParameter("desiredWage")));
            jobApplication.setUser((Long) mysession.getAttribute("id"));
            jobApplication.setPlacementDate(new Date());
            jobApplication.setTypeService(new String(request.getParameter("typeService").getBytes("ISO-8859-1"), "UTF-8"));
            jobApplicationServices.create(jobApplication.getUserId(), jobApplication.getDesiredStartTime(), jobApplication.getDesiredFinishTime(), jobApplication.getDesiredWage(),
                    jobApplication.getPlacementDate(), jobApplication.getTypeService());
            response.sendRedirect("/jobapplication");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("user")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/addjobapplication.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
