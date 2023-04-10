package tn.esprit.asi.ski_project.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="inscriptions")
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numInscription;
    private int numSemaine;

    @ManyToOne
    private Cours cours;
    @ManyToOne
    private Skieur skieur;

    public long getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(long numInscription) {
        this.numInscription = numInscription;
    }

    public int getNumSemaine() {
        return numSemaine;
    }

    public void setNumSemaine(int numSemaine) {
        this.numSemaine = numSemaine;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Skieur getSkieur() {
        return skieur;
    }

    public void setSkieur(Skieur skieur) {
        this.skieur = skieur;
    }
}
