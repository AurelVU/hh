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
import java.util.List;

public class JobApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    JobApplicationServices jobApplicationServices = new JobApplicationServices();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JobApplication> jobApplications = null;
        if (req.getParameterMap().size() != 0)
        {
            Long userId = null;
            Date desiredStartTimeMin = null;
            Date desiredStartTimeMax = null;
            Date desiredFinishTimeMin = null;
            Date desiredFinishTimeMax = null;
            BigDecimal desiredWageMin = null;
            BigDecimal desiredWageMax = null;
            Date placementDateMin = null;
            Date placementDateMax = null;


            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            try {
                if (req.getParameter("minDesiredFinishTime") != null && req.getParameter("minDesiredFinishTime") != "")
                    desiredFinishTimeMin = dateFormat.parse(req.getParameter("minDesiredFinishTime"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                if (req.getParameter("maxDesiredFinishTime") != null && req.getParameter("maxDesiredFinishTime") != "")
                    desiredFinishTimeMax = dateFormat.parse(req.getParameter("maxDesiredFinishTime"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                if (req.getParameter("minDesiredStartTime") != null && req.getParameter("minDesiredStartTime") != "")
                    desiredStartTimeMin = dateFormat.parse(req.getParameter("minDesiredStartTime"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                if (req.getParameter("maxDesiredStartTime") != null && req.getParameter("maxDesiredStartTime") != "")
                    desiredStartTimeMax = dateFormat.parse(req.getParameter("maxDesiredStartTime"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (req.getParameter("minDesiredWage") != null && req.getParameter("minDesiredWage") != "")
                desiredWageMin = new BigDecimal(req.getParameter("minDesiredWage"));
            if (req.getParameter("maxDesiredWage") != null && req.getParameter("maxDesiredWage") != "")
                desiredWageMax = new BigDecimal(req.getParameter("maxDesiredWage"));
            if (req.getParameter("userId") != null && req.getParameter("userId") != "")
                userId = Long.valueOf(req.getParameter("userId"));
            jobApplications = jobApplicationServices.getByParams(userId, desiredStartTimeMin, desiredStartTimeMax,
                    desiredFinishTimeMin, desiredFinishTimeMax,
                    desiredWageMin, desiredWageMax, placementDateMin,
                    placementDateMax);
        } else
        {
            jobApplications = jobApplicationServices.getAll();
        }

        String str = "";
        for (JobApplication u : jobApplications)
        {
            str += "<tr><td>" + u.getId().toString() + "</td><td>" +
                    u.getTypeService() + "</td><td>" +
                    u.getUserId() + "</td><td>" +
                    u.getDesiredStartTime() + "</td><td>" +
                    u.getDesiredFinishTime() + "</td><td>" +
                    u.getDesiredWage() + "</td><td>" +
                    u.getPlacementDate() + "</td></tr>";

        }
        HttpSession mysession = req.getSession();
        if (mysession.getAttribute("type") != null && mysession.getAttribute("type").equals("user")) {
            req.setAttribute("button", "<button type=\"button\" onclick=\"location.href = '/addjobapplication'\" class=\"btn btn-outline-primary ml-1 mt-1\">Добавить</button>");
        }
        req.setAttribute("cont", str);
        req.setAttribute("jobapplication", "active");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jobapplication.jsp");
        requestDispatcher.forward(req, resp);

    }
}
