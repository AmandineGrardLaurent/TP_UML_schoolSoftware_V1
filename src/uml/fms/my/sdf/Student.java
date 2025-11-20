package uml.fms.my.sdf;

public class Student extends Person {

    private int number;

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
