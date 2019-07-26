package com.vivek.spring.cloudfunction.aws.handler;

import com.vivek.spring.cloudfunction.aws.domain.UppercaseRequest;
import com.vivek.spring.cloudfunction.aws.domain.UppercaseResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

/**
 * This is handler class for UpperCaseFunction
 */
public class UppercaseFunctionHandler extends SpringBootRequestHandler<UppercaseRequest, UppercaseResponse> {
}
