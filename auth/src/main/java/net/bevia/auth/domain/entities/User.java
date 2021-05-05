package net.bevia.auth.domain.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="USERS")
public class User implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @Column(name="uuid", length = 16, unique = true, nullable = false)
    private String uuid= UUID.randomUUID().toString();

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String username;

    private String password;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreated  = new Date();

    public User() {
    }

    public User(String name, String lastName, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
}
