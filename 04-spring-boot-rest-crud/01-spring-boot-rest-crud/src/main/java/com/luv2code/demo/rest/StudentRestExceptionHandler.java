package com.luv2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*exception handler globally*/
@ControllerAdvice
public class StudentRestExceptionHandler {

    /*add exception handling code here*/

    /*add  an exception handler using @ExceptionHandler*/

    /*exception handler method*/ /*type of response body*/     /*exception type to handle/catch*/
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){

        /*create  StudentErrorResponse*/
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value() );
        error.setMessage(exception.getMessage() );
        error.setTimeStamp( System.currentTimeMillis() );

        /*return ResponseEntity*/

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    /*add another exception handler to catch any exception (catch all)*/

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){

        /*create  StudentErrorResponse*/
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value() );
        error.setMessage(exception.getMessage() );
        error.setTimeStamp( System.currentTimeMillis() );

        /*return ResponseEntity*/
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST );
    }
}
