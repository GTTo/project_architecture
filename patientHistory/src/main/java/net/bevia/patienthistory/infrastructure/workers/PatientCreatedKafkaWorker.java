package net.bevia.patienthistory.infrastructure.workers;

import net.bevia.patienthistory.domain.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PatientCreatedKafkaWorker {
    Logger log = LoggerFactory.getLogger(PatientCreatedKafkaWorker.class);

    @KafkaListener(topics = "patients")
    public void consumer(Patient patient) {
      log.info("Mensaje recibido -> " + patient);
    }
}
