package tn.esprit.asi.ski_project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity(name="skieurs")
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;

    @ManyToMany
    private Set<Piste> pistes;
    @OneToMany (mappedBy = "skieur")
    private Set<Inscription> inscriptions;

    @OneToOne(cascade = { CascadeType.PERSIST , CascadeType.REMOVE })
    private Abonnement abonnement;



    public void addPiste(Piste piste)
    {
        pistes.add(piste);
    }

    public long getNumSkieur() {
        return numSkieur;
    }

    public void setNumSkieur(long numSkieur) {
        this.numSkieur = numSkieur;
    }

    public String getNomS() {
        return nomS;
    }

    public void setNomS(String nomS) {
        this.nomS = nomS;
    }

    public String getPrenomS() {
        return prenomS;
    }

    public void setPrenomS(String prenomS) {
        this.prenomS = prenomS;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Set<Piste> getPistes() {
        return pistes;
    }

    public void setPistes(Set<Piste> pistes) {
        this.pistes = pistes;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    public void setAbonnement(Abonnement abonnement) {
        this.abonnement = abonnement;
    }
}
