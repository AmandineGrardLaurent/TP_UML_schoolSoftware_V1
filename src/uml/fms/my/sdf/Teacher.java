package uml.fms.my.sdf;

import java.util.Date;
import java.util.List;

public class Teacher extends Person {

    private Date date;
    
    public Teacher (String firstName, String lastName, Integer age, Date date, String road, String city, int zipCode) {
        super(firstName, lastName, age);
        this.date = date;
        setAddress(road, city, zipCode);
    }

    // Getters
    public Date getDate() {
        return this.date;
    }

    // Setters
    

    @Override
    public void setAddress(String road, String city, int zipCode) {
        
        this.road = road;
        this.city = city;
        this.zipCode = zipCode;
    }


  
}
