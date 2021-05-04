package net.bevia.patienthistory.app.services;

import net.bevia.patienthistory.domain.entities.PatientHistory;
import net.bevia.patienthistory.domain.exceptions.PatientHistoryException;

import java.util.Optional;

public interface PatientHistoryService {

    public PatientHistory save (PatientHistory patientHistory) throws PatientHistoryException;

    public Optional<PatientHistory> getPatientHistory(String uuid);
}
