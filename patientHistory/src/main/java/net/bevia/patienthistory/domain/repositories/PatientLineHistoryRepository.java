package net.bevia.patienthistory.domain.repositories;

import net.bevia.patienthistory.domain.entities.PatientLineHistory;
import org.springframework.data.repository.CrudRepository;

public interface PatientLineHistoryRepository extends CrudRepository<PatientLineHistory, String> {
}
