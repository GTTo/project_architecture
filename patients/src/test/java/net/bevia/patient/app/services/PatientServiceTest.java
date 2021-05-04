package net.bevia.patient.app.services;

import net.bevia.patient.domain.entities.Patient;
import net.bevia.patient.domain.exceptions.PatientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Test
    public void addPatient() throws PatientException{
        Patient patient = new Patient(
                "Pepe",
                "Manuel",
                LocalDate.now()
        );

        Patient result = patientService.savePatient(patient);

        assertThat(patient.getName()).isEqualTo(result.getName());
    }
}