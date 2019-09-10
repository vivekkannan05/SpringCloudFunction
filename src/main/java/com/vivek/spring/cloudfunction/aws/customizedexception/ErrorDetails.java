package com.vivek.spring.cloudfunction.aws.customizedexception;

import lombok.Data;

import java.util.Date;

/**
 * Error Details
 * @author C32338
 *
 */
@Data
public class ErrorDetails {
	  private Date timestamp;
	  private String message;

	  /**
	   	 * the constructor to initialize
		 * @param timestamp the timestamp to initialize
		 * @param message the message to initialize
		*/ 
	  public ErrorDetails(Date timestamp, String message) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	  }

}
