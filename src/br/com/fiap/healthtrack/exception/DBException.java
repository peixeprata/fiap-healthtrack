package br.com.fiap.healthtrack.exception;

public class DBException extends Exception {
	
	public DBException() {
		super();
	}
	
	public DBException (String message, Throwable cause, boolean enableSupression, boolean writableStackTrace) {
		super (message, cause, enableSupression, writableStackTrace);
	}
	
	public DBException (String message, Throwable cause) {
		super (message, cause);
	}
	public DBException (String message) {
		super (message);
	}
	public DBException (Throwable cause) {
		super(cause);
	}

}
