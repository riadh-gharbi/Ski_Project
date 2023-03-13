package tn.esprit.asi.ski_project.services;

import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    void add(Abonnement a);
    Abonnement update(Abonnement a);
    List<Abonnement> getAll();
    Abonnement getById(long id);
    void remove(long id);
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);
    Set<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate,

                                                  LocalDate endDate);
}
