package net.bevia.microservice.app.services;

import net.bevia.microservice.app.factories.FactoryPatients;
import net.bevia.microservice.domain.entities.Patient;
import net.bevia.microservice.domain.exceptions.PatientException;
import net.bevia.microservice.domain.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    private static final String TOPIC = "patients";

    @Override
    public Patient savePatient(Patient patient) throws PatientException {
        Patient resultPatient;
        try {
            resultPatient = patientRepository.save(patient);
        } catch (Exception ex){
            throw new PatientException(ex);
        }
        kafkaTemplate.send(TOPIC, patient);
        return resultPatient;
    }

    @Override
    public Mono<Patient> findPatientByUUID(String uuid) {
        return Mono.just(FactoryPatients.toStream().findFirst().get());
    }
}
