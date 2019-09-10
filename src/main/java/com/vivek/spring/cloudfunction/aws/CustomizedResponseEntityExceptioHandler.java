/*
package com.vivek.spring.cloudfunction.aws;

import com.vivek.spring.cloudfunction.aws.customizedexception.ExceptionResponse;
import com.vivek.spring.cloudfunction.aws.customizedexception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomizedResponseEntityExceptioHandler {

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<List<ExceptionResponse>> handleMethodArguementNotValid(ValidationException ex){
        List<ExceptionResponse> exceptionList = new ArrayList<>();
        ex.getErrors().getAllErrors().forEach(er-> exceptionList.add(new ExceptionResponse(er.getDefaultMessage().split(":")[0],
            HttpStatus.BAD_REQUEST.toString(),er.getDefaultMessage().split(":")[1],er.getObjectName())));
        return new ResponseEntity<>(exceptionList, HttpStatus.BAD_REQUEST);
    }

}
*/
