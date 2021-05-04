package net.bevia.patient.app.services;

import net.bevia.patient.domain.entities.Patient;
import net.bevia.patient.domain.exceptions.PatientException;
import reactor.core.publisher.Mono;

public interface PatientService {

    Patient savePatient(Patient patient) throws PatientException;

    Mono<Patient> findPatientByUUID(String uuid);
}
