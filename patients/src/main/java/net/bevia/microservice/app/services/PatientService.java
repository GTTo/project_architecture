package net.bevia.microservice.app.services;

import net.bevia.microservice.domain.entities.Patient;
import net.bevia.microservice.domain.exceptions.PatientException;
import reactor.core.publisher.Mono;

public interface PatientService {

    Patient savePatient(Patient patient) throws PatientException;

    Mono<Patient> findPatientByUUID(String uuid);
}
