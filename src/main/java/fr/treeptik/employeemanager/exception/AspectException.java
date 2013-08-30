package fr.treeptik.employeemanager.exception;

public class AspectException extends Exception {

	private static final long serialVersionUID = 1L;

	public AspectException(String message) {
		super(message);
	}
	
	public AspectException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
