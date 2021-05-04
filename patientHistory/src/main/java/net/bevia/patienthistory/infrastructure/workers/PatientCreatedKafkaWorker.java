package net.bevia.patienthistory.infrastructure.workers;

import net.bevia.patienthistory.app.services.PatientHistoryService;
import net.bevia.patienthistory.domain.entities.PatientHistory;
import net.bevia.patienthistory.domain.exceptions.PatientHistoryException;
import net.bevia.patienthistory.domain.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PatientCreatedKafkaWorker {
    Logger log = LoggerFactory.getLogger(PatientCreatedKafkaWorker.class);

    private PatientHistoryService patientHistoryService;

    public PatientCreatedKafkaWorker(PatientHistoryService patientHistoryService){
        this.patientHistoryService= patientHistoryService;
    }

    @KafkaListener(topics = "patients")
    public void consumer(Patient patient) throws PatientHistoryException {
        log.info("Mensaje recibido ->" + patient.toString());
        PatientHistory patientHistory = new PatientHistory(patient.getName(), patient.getLastName(),patient.getUuid(), "", "");
        patientHistoryService.save(patientHistory);
    }
}
