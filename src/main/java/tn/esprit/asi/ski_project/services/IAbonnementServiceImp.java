package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.repositories.AbonnementRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IAbonnementServiceImp implements IAbonnementService {

    //L'attribut starts as empty since it's private and all that jazz
    //The autowired helps for the link
    @Autowired
    AbonnementRepository abonnementRepository;

    @Override
    public void add(Abonnement a) {
        abonnementRepository.save(a);
    }

    @Override
    public Abonnement update(Abonnement a) {
        return abonnementRepository.save(a);
    }

    @Override
    public List<Abonnement> getAll() {
        return (List<Abonnement>) abonnementRepository.findAll();
    }

    @Override
    public Abonnement getById(long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        abonnementRepository.deleteById(id);
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return abonnementRepository.findByTypeAbon(type);
        // return getAll().stream().filter(abonnement -> abonnement.getTypeAbon() == type).collect(Collectors.toSet());
    }

    @Override
    public Set<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        //return getAll().stream().filter(abonnement -> abonnement.getDateDebut().isBefore(endDate) && abonnement.getDateDebut().isAfter(startDate)).collect(Collectors.toList());
        return abonnementRepository.findByDateDebutBetween(startDate,endDate);
    }
}
