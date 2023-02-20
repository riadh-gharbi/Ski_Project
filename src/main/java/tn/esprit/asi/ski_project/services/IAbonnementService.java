package tn.esprit.asi.ski_project.services;

import tn.esprit.asi.ski_project.entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    void add(Abonnement a);
    Abonnement update(Abonnement a);
    List<Abonnement> getAll();
    Abonnement getById(long id);
    void remove(long id);
}
