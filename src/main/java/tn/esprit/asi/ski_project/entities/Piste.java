package tn.esprit.asi.ski_project.entities;

import javax.persistence.*;
import java.awt.*;
import java.util.List;


@Entity(name="pistes")
public class Piste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numPiste;

    private String nomPiste;

    @Enumerated(EnumType.STRING)
    private Couleur Couleur;
    private int longeur;
    private int pente;

    @ManyToMany(mappedBy = "pistes")
    private List<Skieur> skieurList;


    public long getNumPiste() {
        return numPiste;
    }

    public void setNumPiste(long numPiste) {
        this.numPiste = numPiste;
    }

    public String getNomPiste() {
        return nomPiste;
    }

    public void setNomPiste(String nomPiste) {
        this.nomPiste = nomPiste;
    }

    public tn.esprit.asi.ski_project.entities.Couleur getCouleur() {
        return Couleur;
    }

    public void setCouleur(tn.esprit.asi.ski_project.entities.Couleur couleur) {
        Couleur = couleur;
    }

    public int getLongeur() {
        return longeur;
    }

    public void setLongeur(int longeur) {
        this.longeur = longeur;
    }

    public int getPente() {
        return pente;
    }

    public void setPente(int pente) {
        this.pente = pente;
    }

    public List<Skieur> getSkieurList() {
        return skieurList;
    }

    public void setSkieurList(List<Skieur> skieurList) {
        this.skieurList = skieurList;
    }
}
