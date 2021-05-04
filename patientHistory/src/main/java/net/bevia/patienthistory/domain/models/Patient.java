package net.bevia.patienthistory.domain.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class Patient implements Serializable {
    private static final long serialVersionUID=1L;

    private String uuid;

    private String name;

    private String lastName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    private Date dateCreated;

    public Patient() {};

    public Patient(String name, String lastname, LocalDate birthdate) {
        this.name = name;
        this.lastName = lastname;
        this.birthDate = birthdate;
    }
}
