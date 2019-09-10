package com.vivek.spring.cloudfunction.aws.customizedexception;

import lombok.Data;

/**
 *
 */
@Data
public class ExceptionResponse {
    private String status;
    private String code;
    private String message;
    private String params;

    /**
     * Constructor for ExceptionResponse
     * @param code
     * @param status
     * @param message
     * @param params
     */
    public ExceptionResponse(String code, String status, String message, String params) {
        super();
        this.code = code;
        this.status = status;
        this.message = message;
        this.params = params;
    }

    /**
     * Constructor for ExceptionResponse
     * @param code
     * @param status
     * @param message
     */
    public ExceptionResponse(String code, String status, String message) {
        super();
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
