package net.bevia.microservice.domain.models;

import java.util.List;

public class PatientHistory {

    private String uuid;
    private String patientName;
    private String patientLastName;
    private String patientUuid;
    private String doctor;
    private String specialty;
    //private List<PatientLineHistory> patientLineHistoryList;


    public PatientHistory() {
    }

    public PatientHistory(String patientName, String patientLastName, String patientUuid, String doctor, String specialty) {
        this.patientName = patientName;
        this.patientLastName = patientLastName;
        this.patientUuid = patientUuid;
        this.doctor = doctor;
        this.specialty = specialty;
    }
}
