package com.vivek.spring.cloudfunction.aws.functions;


import com.vivek.spring.cloudfunction.aws.customizedexception.ExceptionResponse;
import com.vivek.spring.cloudfunction.aws.customizedexception.ValidationException;
import com.vivek.spring.cloudfunction.aws.domain.UppercaseRequest;
import com.vivek.spring.cloudfunction.aws.domain.UppercaseResponse;
import com.vivek.spring.cloudfunction.aws.service.UppercaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


/**
 * This service would convert the input String to Upper case and Return it back
 */
@Component("uppercase") @Log4j2
public class UppercaseFunction implements Function<UppercaseRequest, Object> {

    private final UppercaseService uppercaseService;

    public UppercaseFunction(final UppercaseService uppercaseService) {
        this.uppercaseService = uppercaseService;
    }

    private void validateRquest(@Valid @RequestBody UppercaseRequest uppercaseRequest, Errors errors){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        SpringValidatorAdapter springValidator = new SpringValidatorAdapter(validator);
        springValidator.validate(uppercaseRequest, errors);
        if(errors.hasErrors()){
            throw new ValidationException(errors);
        }

    }

    @Override public Object apply(@Valid @RequestBody final UppercaseRequest uppercaseRequest) {

        try {
            log.info("Entering the function ", uppercaseRequest);
            validateRquest(uppercaseRequest, new BeanPropertyBindingResult(uppercaseRequest, "uppercaseRequest"));
        final UppercaseResponse result = new UppercaseResponse();
        if(uppercaseRequest.getInput().equalsIgnoreCase("test")){
            throw new Exception();
        }
        result.setResult(uppercaseService.uppercase(uppercaseRequest.getInput()));

            return ResponseEntity.ok(result);
        }catch (ValidationException ve){
            log.error("Validation Error while executing uppercase Function", ve);
            List<ExceptionResponse> exceptionList = new ArrayList<>();
            ve.getErrors().getAllErrors().forEach(er-> exceptionList.add(new ExceptionResponse(er.getDefaultMessage().split(":")[0],
                HttpStatus.BAD_REQUEST.toString(),er.getDefaultMessage().split(":")[1],er.getObjectName())));
            return ResponseEntity.badRequest().body(exceptionList);
        }
        catch(Exception e) {
            log.error("Error while executing uppercase Function", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ExceptionResponse("500", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Technical Error"));
        }
    }
}
