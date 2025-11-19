package uml.fms.my.sdf;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Training {
    // Attributes
    private String trainingName;
    private Date startDate;
    private Date endDate;

    private List<Student> students;
    private List<Lesson> lessons;
    // Constructor
    public Training(String trainingName, Date startDate, Date endDate) {
        this.trainingName = trainingName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // ²Getters and Setters
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
    // Methods to manage students and lessons
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public void addLesson(Lesson lesson) {
        if (!lessons.contains(lesson)) {
            lessons.add(lesson);
        }
    }

    public void removeLesson(Lesson lesson) {
        lessons.remove(lesson);
    }

    public List<Lesson> getLessons() {
        return new ArrayList<>(lessons);
    }

    @Override
    public String toString() {
        return "Training Name: " + trainingName + ", Start Date: " + startDate + ", End Date: " + endDate;
    }

    public static void main(String[] args) {
        Training training = new Training("Java Basics", Date.valueOf("2024-07-01"), Date.valueOf("2024-07-15"));
        System.out.println(training.toString());
    }
}
