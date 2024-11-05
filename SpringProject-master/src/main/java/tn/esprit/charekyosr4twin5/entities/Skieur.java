package tn.esprit.charekyosr4twin5.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idskier;
    private String name;

    private LocalDate birthDate;
    private String city;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    Subscription subscription;

    @OneToMany(mappedBy = "skieur")
    Set<Registration> registrations;

    @ManyToMany
    Set<Piste> pistes;

}
