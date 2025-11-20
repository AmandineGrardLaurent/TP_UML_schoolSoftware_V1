package uml.fms.my.sdf;

import java.time.LocalDate;

public class Teacher extends Person {

    private LocalDate date;

    public Teacher(String firstName,
            String lastName,
            int age,
            LocalDate date,
            String road,
            String city,
            int zipCode) {
        super(firstName, lastName, age);
        this.date = date;
        setAddress(road, city, zipCode);
    }

    // Getters
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public void setAddress(String road, String city, int zipCode) {
        this.road = road;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getFullName() + '\'' +
                ", age=" + getAge() +
                ", hireDate=" + date +
                ", road='" + road + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}
