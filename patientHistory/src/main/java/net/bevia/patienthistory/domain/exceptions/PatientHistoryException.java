package net.bevia.patienthistory.domain.exceptions;

public class PatientHistoryException extends Exception{

    public PatientHistoryException() {
        super();
    }

    public PatientHistoryException(String message) {
        super(message);
    }

    public PatientHistoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientHistoryException(Throwable cause) {
        super(cause);
    }
}
