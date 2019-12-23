package app.service;

import app.domain.JobApplication;
import app.persistence.DAO;
import app.persistence.MySqlDAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JobApplicationServices {
    DAO<JobApplication> jobApplicationDAO = new MySqlDAO<>(JobApplication.class);


    public void create(Long userId, Date desiredStartTime, Date desiredFinishTime, BigDecimal desiredWage, Date placementDate,
                String typeService)
    {
        JobApplication jobApplication = new JobApplication(userId, desiredStartTime, desiredFinishTime, desiredWage,
                placementDate, typeService);
        jobApplicationDAO.create(jobApplication);
    }

    public void delete(Long id)
    {
        jobApplicationDAO.delete(id);
    }

    public void change(Long id, Long userId, Date desiredStartTime, Date desiredFinishTime, BigDecimal desiredWage,
                Date placementDate, String typeService)
    {
        JobApplication jobApplication = new JobApplication(userId, desiredStartTime, desiredFinishTime, desiredWage,
                placementDate, typeService);
        jobApplication.setId(id);
        try {
            jobApplicationDAO.update(jobApplication);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public List<JobApplication> getAll()
    {
        return jobApplicationDAO.readAll();
    }

    public JobApplication getById(Long id)
    {
        return jobApplicationDAO.readById(id);
    }

    public List<JobApplication> getByParams(Long userId, Date desiredStartTimeMin, Date desiredStartTimeMax,
                                            Date desiredFinishTimeMin, Date desiredFinishTimeMax,
                                            BigDecimal desiredWageMin, BigDecimal desiredWageMax, Date placementDateMin,
                                            Date placementDateMax)
    {
        HashMap<String, Object> equilMap = new HashMap<>();
        HashMap<String, Object> minMap = new HashMap<>();
        HashMap<String, Object> maxMap = new HashMap<>();




        if (userId != null)
        {
            equilMap.put("userId", userId);
        }

        if (desiredStartTimeMin != null)
        {
            minMap.put("desiredStartTime", desiredStartTimeMin);
        }

        if (desiredStartTimeMax != null)
        {
            maxMap.put("desiredStartTime", desiredStartTimeMax);
        }

        if (desiredFinishTimeMin != null)
        {
            minMap.put("desiredFinishTime", desiredFinishTimeMin);
        }

        if (desiredFinishTimeMax != null)
        {
            maxMap.put("desiredFinishTime", desiredFinishTimeMax);}

        if (desiredWageMin != null)
        {
            minMap.put("desiredWage", desiredWageMin);
        }

        if (desiredWageMax != null)
        {
            maxMap.put("desiredWage", desiredWageMax);
        }

        if (placementDateMin != null)
        {
            minMap.put("placementDate", placementDateMin);
        }

        if (placementDateMax != null)
        {
            maxMap.put("placementDate", placementDateMax);
        }

        return jobApplicationDAO.readByParams(minMap, maxMap, equilMap);
    }
}
