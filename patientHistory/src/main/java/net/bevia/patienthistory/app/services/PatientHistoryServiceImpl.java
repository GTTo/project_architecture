package net.bevia.patienthistory.app.services;

import net.bevia.patienthistory.domain.entities.PatientHistory;
import net.bevia.patienthistory.domain.exceptions.PatientHistoryException;
import net.bevia.patienthistory.domain.repositories.PatientHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientHistoryServiceImpl implements PatientHistoryService {

    private PatientHistoryRepository patientHistoryRepository;

    @Autowired
    public PatientHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository){
        this.patientHistoryRepository = patientHistoryRepository;
    }

    @Override
    public PatientHistory save(PatientHistory patientHistory) throws PatientHistoryException {
        PatientHistory historyCreated = null;
        try{
            historyCreated = patientHistoryRepository.save(patientHistory);
        } catch (Exception ex){
            throw new PatientHistoryException(ex);
        }
        return historyCreated;
    }

    @Override
    public Optional<PatientHistory> getPatientHistory(String uuid) {
        return  patientHistoryRepository.findByPatientUuid(uuid);
    }
}
