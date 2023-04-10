package tn.esprit.asi.ski_project.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity(name="moniteurs")
public class Moniteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numMoniteur;

    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;

    @OneToMany
    private Set<Cours> coursList;

    public long getNumMoniteur() {
        return numMoniteur;
    }

    public void setNumMoniteur(long numMoniteur) {
        this.numMoniteur = numMoniteur;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getPrenomM() {
        return prenomM;
    }

    public void setPrenomM(String prenomM) {
        this.prenomM = prenomM;
    }

    public LocalDate getDateRecru() {
        return dateRecru;
    }

    public void setDateRecru(LocalDate dateRecru) {
        this.dateRecru = dateRecru;
    }

    public Set<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(Set<Cours> coursList) {
        this.coursList = coursList;
    }
}
