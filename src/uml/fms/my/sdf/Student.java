package uml.fms.my.sdf;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private int number;

    private final List<Lesson> lessons = new ArrayList<>();

    public Student(int number,
            String firstName,
            String lastName,
            int age,
            String road,
            String city,
            int zipCode) {
        super(firstName, lastName, age);
        this.number = number;
        setAddress(road, city, zipCode);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addLesson(Lesson lesson) {
        if (lesson == null) {
            throw new IllegalArgumentException("Lesson cannot be null");
        }
        if (!lessons.contains(lesson)) {
            lessons.add(lesson);
        }
    }

    public List<Lesson> getLessons() {
        return new ArrayList<>(lessons);
    }

    @Override
    public void setAddress(String road, String city, int zipCode) {
        this.road = road;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number : " + number +
                ", name : " + getFullName() + '\'' +
                ", age : " + getAge() +
                ", road : " + road + '\'' +
                ", city : " + city + '\'' +
                ", zipCode : " + zipCode +
                '}';
    }
}
