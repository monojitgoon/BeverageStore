package de.uniba.dsg.dsam.persistence.exception;

public class DsamPersistenceException extends Exception{

	public DsamPersistenceException() {
	}

	public DsamPersistenceException(String message) {
		super(message);
	}

	public DsamPersistenceException(Throwable cause) {
		super(cause);
	}

	public DsamPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}

}
