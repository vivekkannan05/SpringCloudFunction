package com.vivek.spring.cloudfunction.aws.functions;

import org.springframework.stereotype.Component;

import java.util.function.UnaryOperator;
@Component("greeter")
public class Greeter implements UnaryOperator<String> {

    @Override
    public String apply(String s) {
        return "Hello " + s + ", and welcome to Spring Cloud Function!!!";
    }
}
