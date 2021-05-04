package net.bevia.patient.app.factories;

import net.bevia.patient.domain.entities.Patient;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FactoryPatients {

    private static List<Patient> toList(){
        final var patient = new Patient("prueba", "prueba", LocalDate.now());
        return Arrays.asList(patient, null, patient);
    }

    public static Stream<Patient> toStream(){
        return toList().stream();
    }
}
