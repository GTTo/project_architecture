package net.bevia.patienthistory.app.services;

import net.bevia.patienthistory.domain.entities.PatientLineHistory;
import net.bevia.patienthistory.domain.exceptions.PatientHistoryNotFoundException;

public interface PatientLineHistoryService {

    public PatientLineHistory save(String uuid, PatientLineHistory patientLineHistory) throws PatientHistoryNotFoundException;
}
