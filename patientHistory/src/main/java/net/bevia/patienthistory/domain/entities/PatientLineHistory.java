package net.bevia.patienthistory.domain.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "HISTORYLINES")
public class PatientLineHistory {
    @Id
    @Column(name = "uuid", length = 16, unique = true, nullable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "acto")
    private String acto;

    @Column(name = "prueba")
    private String prueba;

    @Column
    private String doctor;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated  = new Date();

    @Column(name = "cab_uuid")
    private String cabUUID;

    public PatientLineHistory() {

    }
    public PatientLineHistory(String acto, String prueba, String doctor) {
        this.acto = acto;
        this.prueba = prueba;
        this.doctor = doctor;
    }

}
