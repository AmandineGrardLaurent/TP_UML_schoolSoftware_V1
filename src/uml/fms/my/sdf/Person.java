package uml.fms.my.sdf;

public abstract class Person implements Address {

    private String firstName;
    private String lastName;
    private int age;

    protected String road;
    protected String city;
    protected int zipCode;

    /////////////// CONSTRUCTOR //////////////////////////

    protected Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    ///////////////////////// IDENTITY ///////////////////////////////

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    ////////////////// ADDRESS /////////////////////////////////////

    @Override
    public String getRoad() {
        return road;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public int getZipCode() {
        return zipCode;
    }

    @Override
    public abstract void setAddress(String road, String city, int zipCode);
}
