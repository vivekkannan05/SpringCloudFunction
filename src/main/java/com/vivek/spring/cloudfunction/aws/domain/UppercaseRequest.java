package com.vivek.spring.cloudfunction.aws.domain;

import javax.validation.constraints.NotEmpty;

/**
 * Model for Upper Case Request
 */
public class UppercaseRequest {

    @NotEmpty(message = "1000:Input cannot be null")
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(final String input) {
        this.input = input;
    }
}
