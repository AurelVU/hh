package app.domain;


import app.domain.annotations.SQLinformationClass;
import app.domain.annotations.SQLinformationVariable;

import java.math.BigDecimal;
import java.util.Date;

@SQLinformationClass(name = "job_offer")
public class JobOffer extends Entity //Предложение работы
{
    @SQLinformationVariable(name = "employer", SQLtype = "INT")
    private Long employerId;
    @SQLinformationVariable(name = "desired_start_time", SQLtype = "DATE")
    private Date desiredStartTime;
    @SQLinformationVariable(name = "desired_finish_time", SQLtype = "DATE")
    private Date desiredFinishTime;
    @SQLinformationVariable(name = "desired_wage", SQLtype = "INT(20)")
    private BigDecimal desiredWage;
    @SQLinformationVariable(name = "placement_date", SQLtype = "DATE")
    private Date placementDate;
    @SQLinformationVariable(name = "requirements", SQLtype = "VARCHAR(100)")
    private String requirements;

    public JobOffer(Long employerId, Date desiredStartTime, Date desiredFinishTime, BigDecimal desiredWage, Date placementDate, String requirements, String other) {
        this.employerId = employerId;
        this.desiredStartTime = desiredStartTime;
        this.desiredFinishTime = desiredFinishTime;
        this.desiredWage = desiredWage;
        this.placementDate = placementDate;
        this.requirements = requirements;
        this.other = other;
    }

    public JobOffer() {
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployer(Long employerId) {
        this.employerId = employerId;
    }

    public Date getDesiredStartTime() {
        return desiredStartTime;
    }

    public void setDesiredStartTime(Date desiredStartTime) {
        this.desiredStartTime = desiredStartTime;
    }

    public Date getDesiredFinishTime() {
        return desiredFinishTime;
    }

    public void setDesiredFinishTime(Date desiredFinishTime) {
        this.desiredFinishTime = desiredFinishTime;
    }

    public BigDecimal getDesiredWage() {
        return desiredWage;
    }

    public void setDesiredWage(BigDecimal desiredWage) {
        this.desiredWage = desiredWage;
    }

    public Date getPlacementDate() {
        return placementDate;
    }

    public void setPlacementDate(Date placementDate) {
        this.placementDate = placementDate;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @SQLinformationVariable(name = "other", SQLtype = "VARCHAR(1000)")
    private String other;

    @Override
    public String toString() {
        return "id " + id.toString() + ", Создатель " + employerId.toString() + ", начало работы " + desiredStartTime + ", дата завершения работы " +
                desiredFinishTime + ", оплата " + desiredWage.toString() + ", дата размещения " + placementDate.toString()
                + ", требования " + requirements + ", прочее " + other;
    }
}
