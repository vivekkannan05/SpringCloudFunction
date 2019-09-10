package com.vivek.spring.cloudfunction.aws.customizedexception;


/**
 * The Class CustomRuntimeException.
 */
public class CustomRuntimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The error code. */
	private int errorCode;
	
	/** The error codes. */
	private String errorCodes;

	/**
	 * The field
	 */
	private String fields;
	/**
	 * Instantiates a new custom runtime exception.
	 *
	 * @param t the t
	 */
	public CustomRuntimeException(Throwable t) {
	}
	/**
	 * Instantiates a new rating exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public CustomRuntimeException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public CustomRuntimeException(int errorCode, String message,String fields) {
		super(message);
		this.errorCode = errorCode;
		this.fields=fields;
	}
	/**
	 * 
	 * 	/**
	 * Instantiates a new rating exception.
	 *
	 * @param errorCode the error code
	 * @param message the message
	 */
	public CustomRuntimeException(String errorCode, String message) {
		super(message);
		this.errorCodes = errorCode;
	}
  
   
	
	/**
	 * The Constructor.
	 *
	 * @param string the string
	 */
	public CustomRuntimeException(String string) {
		super(string);
	}
	/**
	 * Gets the error code.
	 *
	 * @return the error code
	 */
	public int getErrorCode() {
		return errorCode;
	}
	
	/**
	 * Sets the error code.
	 *
	 * @param errorCode the new error code
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	/**
	 * Gets the error codes.
	 *
	 * @return the error codes
	 */
	public String getErrorCodes() {
		return errorCodes;
	}
	
	/**
	 * Sets the error codes.
	 *
	 * @param errorCodes the new error codes
	 */
	public void setErrorCodes(String errorCodes) {
		this.errorCodes = errorCodes;
	}

	/**
	 * Returns the fields that are processed
	 * @return fields fields
	 */
	public String getFields() {
		return fields;
	}

	/**
	 * sets the fields that will be processed
	 * @param fields fields
	 */
	public void setFields(String fields) {
		this.fields = fields;
	}
}
