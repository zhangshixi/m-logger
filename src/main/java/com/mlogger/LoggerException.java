package com.mlogger;

public class LoggerException extends RuntimeException {

	private static final long serialVersionUID = -6287895169421597065L;

	public LoggerException() {
		super();
	}

	public LoggerException(String message) {
		super(message);
	}

	public LoggerException(Throwable cause) {
		super(cause);
	}

	public LoggerException(String message, Throwable cause) {
		super(message, cause);
	}

}
