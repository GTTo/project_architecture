package net.bevia.patient.domain.exceptions;

public class PatientException extends Exception{
    public PatientException() {
        super();
    }

    public PatientException(String message) {
        super(message);
    }

    public PatientException(String message, Throwable cause) {
        super(message, cause);
    }

    public PatientException(Throwable cause) {
        super(cause);
    }
}
