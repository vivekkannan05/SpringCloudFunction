package com.vivek.spring.cloudfunction.aws.customizedexception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

    private Errors errors;

    public ValidationException(){

    }

    public ValidationException(Errors errors){
        super();
        this.errors = errors;
    }
    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }
}
