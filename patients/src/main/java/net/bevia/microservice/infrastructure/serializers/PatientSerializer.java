package net.bevia.microservice.infrastructure.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.bevia.microservice.domain.entities.Patient;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class PatientSerializer implements Serializer<Patient> {

    private Logger log = LoggerFactory.getLogger(PatientSerializer.class);

    @Override
    public byte[] serialize(String s, Patient patient) {
        ObjectMapper mapper = new ObjectMapper();
        byte[] retVal = null;
        try {
            retVal  = mapper.writeValueAsString(patient).getBytes(StandardCharsets.UTF_8);
        } catch (Exception ex){
            log.error(ex.getMessage());
        }
        return retVal;
    }

}
