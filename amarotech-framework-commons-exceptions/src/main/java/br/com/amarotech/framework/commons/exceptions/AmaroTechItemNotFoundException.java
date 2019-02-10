package br.com.amarotech.framework.commons.exceptions;

/**
 * Exception when don't exist item in list.
 * @author mamaro
 *
 */
public class AmaroTechItemNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -2425805439254125670L;
	
	private String code;
	private String details;
	
	public AmaroTechItemNotFoundException(Throwable exception) {
		super(exception);
	}
	public AmaroTechItemNotFoundException(String message) {
		this(message, null, null);
	}
	public AmaroTechItemNotFoundException(String message, String code) {
		this(message, code, null);
	}
	public AmaroTechItemNotFoundException(String message, String code, String details) {
		super(message);
		this.code = code;
		this.details = details;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getDetails() {
		return details;
	}
}