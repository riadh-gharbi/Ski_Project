package tn.esprit.asi.ski_project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;




@Entity(name="abonnements")
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAbon;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private float prixAbon;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;

    public Long getNumAbon() {
        return numAbon;
    }

    public void setNumAbon(long numAbon) {
        this.numAbon = numAbon;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public float getPrixAbon() {
        return prixAbon;
    }

    public void setPrixAbon(float prixAbon) {
        this.prixAbon = prixAbon;
    }

    public TypeAbonnement getTypeAbon() {
        return typeAbon;
    }

    public void setTypeAbon(TypeAbonnement typeAbon) {
        this.typeAbon = typeAbon;
    }
}
