package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;
    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    /*add own custom logic*/
                        /*html form data entered by the user*/   /*additional error messages*/
    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (code != null) {
            result = code.startsWith(coursePrefix);
        }
        else {
            result = true;
        }

        return result;
    }
}
