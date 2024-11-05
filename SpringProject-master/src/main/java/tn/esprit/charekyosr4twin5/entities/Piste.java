package tn.esprit.charekyosr4twin5.entities;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table
public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;
    private String namePiste;



    private int length;
    private int slope;
    private LocalTime birthDate;

    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToMany(mappedBy = "pistes")
    Set<Skieur> skieurs;
}