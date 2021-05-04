package net.bevia.patienthistory.domain.repositories;

import net.bevia.patienthistory.domain.entities.PatientHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PatientHistoryRepository extends CrudRepository<PatientHistory, String> {

    Optional<PatientHistory> findByPatientUuid(String patienUUID);
}
