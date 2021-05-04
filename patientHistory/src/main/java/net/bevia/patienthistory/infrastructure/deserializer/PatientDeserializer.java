package net.bevia.patienthistory.infrastructure.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.bevia.patienthistory.domain.models.Patient;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientDeserializer implements Deserializer {

    private Logger log = LoggerFactory.getLogger(PatientDeserializer.class);

    @Override
    public Patient deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Patient patient = null;
        try {
            patient = mapper.readValue(bytes, Patient.class);
        } catch (Exception ex){
            log.error(ex.getMessage());
        }
        return patient;
    }
}
