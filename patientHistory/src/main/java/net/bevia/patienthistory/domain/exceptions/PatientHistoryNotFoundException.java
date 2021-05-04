package net.bevia.patienthistory.domain.exceptions;

public class PatientHistoryNotFoundException extends Exception {
    public PatientHistoryNotFoundException() {
        super();
    }

    public PatientHistoryNotFoundException(String message) {
        super(message);
    }

    public PatientHistoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientHistoryNotFoundException(Throwable cause) {
        super(cause);
    }
}
