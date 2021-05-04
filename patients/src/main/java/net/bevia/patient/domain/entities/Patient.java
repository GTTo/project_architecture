package net.bevia.patient.domain.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="PATIENTS")
public class Patient implements Serializable {
    private static final long serialVersionUID=1L;

    public Patient() {
    }

    public Patient(String name, String lastname, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastname;
        this.birthDate = birthDate;
    }

    @Id
    @Column(name="uuid", length = 16, unique = true, nullable = false)
    private String uuid= UUID.randomUUID().toString();

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated  = new Date();

}
