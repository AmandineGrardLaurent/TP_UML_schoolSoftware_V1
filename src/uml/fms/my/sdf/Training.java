package uml.fms.my.sdf;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Training {

    // Attributes
    private String trainingName;
    private LocalDate startDate;
    private LocalDate endDate;

    private List<Student> students;
    private List<Lesson> lessons;

    // Constructor
    public Training(String trainingName, LocalDate startDate, LocalDate endDate) {
        validateDates(startDate, endDate);
        this.trainingName = trainingName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    // Validation method
    private void validateDates(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException(
                "La date de début ne peut pas être après la date de fin."
            );
        }
    }

    // Getters and Setters
    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setStartDate(LocalDate startDate) {
        validateDates(startDate, this.endDate);
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        validateDates(this.startDate, endDate);
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
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

    // public static void main(String[] args) {
    //     Training training = new Training("Java Basics", 
    //         LocalDate.of(2024, 7, 1), 
    //         LocalDate.of(2025, 7, 15));
    //     System.out.println(training.toString());
    // }
}
