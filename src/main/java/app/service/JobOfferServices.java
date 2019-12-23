package app.service;

import app.domain.JobOffer;
import app.persistence.DAO;
import app.persistence.MySqlDAO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JobOfferServices {
    DAO<JobOffer> jobOfferDAO = new MySqlDAO<>(JobOffer.class);

    public void create(Long employerId, Date desiredStartTime, Date desiredFinishTime, BigDecimal desiredWage, Date placementDate, String requirements, String other) {
        JobOffer jobOffer = new JobOffer(employerId, desiredStartTime, desiredFinishTime, desiredWage, placementDate,
                requirements, other);
        jobOfferDAO.create(jobOffer);
    }

    public void delete(Long id) {
        jobOfferDAO.delete(id);
    }

    public void change(Long id, Long employerId, Date desiredStartTime, Date desiredFinishTime, BigDecimal desiredWage,
                       Date placementDate, String requirements, String other) {
        JobOffer jobOffer = new JobOffer(employerId, desiredStartTime, desiredFinishTime, desiredWage, placementDate,
                requirements, other);
        jobOffer.setId(id);
        try {
            jobOfferDAO.update(jobOffer);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public List<JobOffer> getAll() {
        return jobOfferDAO.readAll();
    }

    public JobOffer getById(Long id) {
        return jobOfferDAO.readById(id);
    }

    public List<JobOffer> getByParams(Long employerId, Date desiredStartTimeMax, Date desiredStartTimeMin,
                                      Date desiredFinishTimeMax, Date desiredFinishTimeMin, BigDecimal desiredWageMax,
                                      BigDecimal desiredWageMin, Date placementDateMax, Date placementDateMin) {
        HashMap<String, Object> equilMap = new HashMap<>();
        HashMap<String, Object> minMap = new HashMap<>();
        HashMap<String, Object> maxMap = new HashMap<>();

        if (employerId != null) {
            equilMap.put("employerId", employerId);
        }

        if (desiredStartTimeMin != null) {
            minMap.put("desiredStartTime", desiredStartTimeMin);
        }

        if (desiredStartTimeMax != null) {
            maxMap.put("desiredStartTime", desiredStartTimeMax);
        }

        if (desiredFinishTimeMin != null) {
            minMap.put("desiredFinishTime", desiredFinishTimeMin);
        }

        if (desiredFinishTimeMax != null) {
            maxMap.put("desiredFinishTime", desiredFinishTimeMax);
        }

        if (desiredWageMin != null) {
            minMap.put("desiredWage", desiredWageMin);
        }

        if (desiredWageMax != null) {
            maxMap.put("desiredWage", desiredWageMax);
        }

        if (placementDateMin != null) {
            minMap.put("placementDate", placementDateMin);
        }

        if (placementDateMax != null) {
            maxMap.put("placementDate", placementDateMax);
        }

        return jobOfferDAO.readByParams(minMap, maxMap, equilMap);
    }
}
