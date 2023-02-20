package tn.esprit.asi.ski_project.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name="moniteurs")
public class Moniteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numMoniteur;

    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;

    @OneToMany
    private List<Cours> coursList;

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

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }
}
