package app.servlets;

import app.domain.JobApplication;
import app.service.JobApplicationServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JobApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    JobApplicationServices jobApplicationServices = new JobApplicationServices();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<JobApplication> jobApplications = jobApplicationServices.getAll();
        String str = "";
        for (JobApplication u : jobApplications)
        {
            str += "<tr><td>" + u.getId().toString() + "</td><td>" +
                    u.getTypeService() + "</td><td>" +
                    u.getUserId() + "</td><td>" +
                    u.getDesiredStartTime() + "</td><td>" +
                    u.getDesiredFinishTime() + "</td><td>" +
                    u.getDesiredWage() + "</td></td>" +
                    u.getPlacementDate() + "</td></tr>";

        }
        req.setAttribute("cont", str);
        req.setAttribute("jobapplication", "active");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/jobapplication.jsp");
        requestDispatcher.forward(req, resp);

    }
}
