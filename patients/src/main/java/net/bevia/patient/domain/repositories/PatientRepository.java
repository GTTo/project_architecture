package net.bevia.patient.domain.repositories;

import net.bevia.patient.domain.entities.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, String> {

}
