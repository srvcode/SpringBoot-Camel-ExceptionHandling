package com.srvcode.camel.exceptions;

public class CamelCustomException extends Exception {

	private static final long serialVersionUID = 1L;
	public CamelCustomException(final Throwable cause) {
        super(cause);
    }

    public CamelCustomException(final String message) {
        super(message);
    }

    public CamelCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
