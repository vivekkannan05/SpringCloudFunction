package com.vivek.spring.cloudfunction.aws.functions;


import com.vivek.spring.cloudfunction.aws.domain.UppercaseRequest;
import com.vivek.spring.cloudfunction.aws.domain.UppercaseResponse;
import com.vivek.spring.cloudfunction.aws.service.UppercaseService;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("uppercaseFunction")
public class UppercaseFunction implements Function<UppercaseRequest, UppercaseResponse> {

    private final UppercaseService uppercaseService;

    public UppercaseFunction(final UppercaseService uppercaseService) {
        this.uppercaseService = uppercaseService;
    }

    @Override
    public UppercaseResponse apply(final UppercaseRequest uppercaseRequest) {
        final UppercaseResponse result = new UppercaseResponse();

        result.setResult(uppercaseService.uppercase(uppercaseRequest.getInput()));

        return result;
    }
}
