package net.bevia.patienthistory.app.services;

import net.bevia.patienthistory.domain.entities.PatientHistory;
import net.bevia.patienthistory.domain.entities.PatientLineHistory;
import net.bevia.patienthistory.domain.exceptions.PatientHistoryException;
import net.bevia.patienthistory.domain.exceptions.PatientHistoryNotFoundException;
import net.bevia.patienthistory.domain.repositories.PatientHistoryRepository;
import net.bevia.patienthistory.domain.repositories.PatientLineHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientLineHistoryServiceImpl implements PatientLineHistoryService {

    private PatientHistoryRepository patientHistoryRepository;
    private PatientLineHistoryRepository patientLineHistoryRepository;

    public PatientLineHistoryServiceImpl(PatientHistoryRepository patientHistoryRepository, PatientLineHistoryRepository patientLineHistoryRepository) {
        this.patientHistoryRepository = patientHistoryRepository;
        this.patientLineHistoryRepository = patientLineHistoryRepository;
    }

    @Override
    public PatientLineHistory save(String uuid, PatientLineHistory patientLineHistory) throws PatientHistoryNotFoundException {
        Optional<PatientHistory> patientHistory;
        try{
            patientHistory = patientHistoryRepository.findById(uuid);
            patientLineHistory.setCabUUID(patientHistory.get().getUuid());
            return patientLineHistoryRepository.save(patientLineHistory);
        } catch (Exception ex){
            throw new PatientHistoryNotFoundException(ex.getMessage());
        }
    }
}
