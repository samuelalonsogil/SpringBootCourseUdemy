package com.luv2code.springdemo.mvc.model;

import com.luv2code.springdemo.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    //@NotNull(message="is required")
    @CourseCode(value = "TOPS", message = "must start with TOPS")
    private String courseCode;

    /*convert from int to Integer, so it can process the required*/
    @NotNull(message="is required")
    @Min( value= 0 ,message = "must be higher or equal to 0")
    @Max( value= 10 ,message = "must be lower or equal to 10")
    private Integer freePasses;
    private String firstName;
    @NotNull(message="is required")
    @Size(min=1, message="must be at least 1 character")
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
    private String postalCode;

    public Customer() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
