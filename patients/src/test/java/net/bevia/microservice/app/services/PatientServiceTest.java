package net.bevia.microservice.app.services;

import net.bevia.microservice.app.services.PatientService;
import net.bevia.microservice.domain.entities.Patient;
import net.bevia.microservice.domain.exceptions.PatientException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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