package uml.fms.my.sdf;

import java.sql.Date;

public class Training {
    String trainingName;
    Date startDate;
    Date endDate; 

    public Training(String trainingName, Date startDate, Date endDate) {
        this.trainingName = trainingName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Date getEndDate() {
        return endDate;
    }

    public String toString() {
        return "Training Name: " + trainingName + ", Start Date: " + startDate + ", End Date: " + endDate;
    }



    public static void main(String[] args) {
        Training training = new Training("Java Basics", Date.valueOf("2024-07-01"), Date.valueOf("2024-07-15"));
        System.out.println(training.toString());
    }
}
