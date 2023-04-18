package tn.esprit.asi.ski_project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import tn.esprit.asi.ski_project.entities.*;
import tn.esprit.asi.ski_project.repositories.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


//the @Service indicates to the project to create an instance of this class to be called by the Controller
//We don't need to do it in the repository because the Spring Data JPA takes care of it by scanning the project (explained down below)
@Service
@RequiredArgsConstructor
public class ISkieurServiceImp implements ISkieurService {
    //Injection de dépendances
    //the skieur repo is empty without instance
    //Spring Data JPA is the one that creates the instance on runtime
    //It scans the project for Interfaces that extends from JPARepo or SortingAndPagination or CrudRepository
    //The instances are located in the project context in the form of beans
    //It injects the instance to the variable with autowired
    //It is a dependency which is injected inside the variable.

    private final SkieurRepository skieurRepository;

    private final PisteRepository pisteRepository;

    private final AbonnementRepository abonnementRepository;

    private final InscriptionRepository inscriptionRepository;
    private final CoursRepository coursRepository;

    @Override
    @Transactional
    public void add(Skieur s) {
        //Traitement quelconque
        //Abonnement abonAjouter = s.getAbonnement();
        //Abonnement addedAbon = abonnementRepository.save(abonAjouter);
        //Skieur addedSkieur = skieurRepository.save(s);
        //addedSkieur.setAbonnement(addedAbon);
        //skieurRepository.save(addedSkieur);
        skieurRepository.save(s);
        //Abonnement abonAjouter1 = s.getAbonnement();
        //abonnementRepository.saveAndFlush(abonAjouter1);
        //skieurRepository.saveAndFlush(s);
        //s.setAbonnement(abonAjouter1);
        //skieurRepository.save(s);
    }

    @Override
    public Skieur update(Skieur s) {
        return skieurRepository.save(s);
    }

    @Override
    public List<Skieur> getAll() {
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public Skieur getById(long id) {
        return skieurRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        skieurRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        if(skieurRepository.existsById(numSkieur) && pisteRepository.existsById(numPiste)){
            Skieur s= skieurRepository.findById(numSkieur).get();
            s.addPiste(pisteRepository.findById(numPiste).get());
            return s;
        }
        return null;
    }

    @Override
    @Transactional
    public Skieur assignSkieurToAbon(Long numSkieur, Long numAbon) {
        if(skieurRepository.existsById(numSkieur) && abonnementRepository.existsById(numAbon))
        {
            Skieur s = skieurRepository.findById(numSkieur).get();
            s.setAbonnement(abonnementRepository.findById(numAbon).get());
            return s;
        }
        return null;
    }

    @Override
    @Transactional
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {
        //Créer Abonnement
        //Abonnement a = skieur.getAbonnement();
        //if(a != null && skieur.getInscriptions() != null){
        //abonnementRepository.save(a);
        //inscriptionRepository.saveAll(skieur.getInscriptions());
        //return skieurRepository.save(skieur);}
        //return null;

        //Nested Object
        Abonnement  a = skieur.getAbonnement();
        Assert.notNull(a,"Abonnement ne doit pas etre null");
        Set<Inscription> inscriptions = skieur.getInscriptions();
        inscriptions.forEach(inscription -> {
            Assert.notNull(inscription.getCours(),"no Cours Found");
            Assert.notNull(inscription.getCours().getNumCours(),"no numCours found");
                    Cours c =coursRepository.findById(inscription.getCours().getNumCours()).orElse(null);
                    Assert.notNull(c,"cours not in database");
                    inscription.setCours(c);


                }
               );
        skieurRepository.saveAndFlush(skieur);
        skieur.getInscriptions().forEach(inscription -> {
            inscription.setSkieur(skieur);
            inscriptionRepository.save(inscription);});
        return skieur;


    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        //return getAll().stream().filter(skieur -> skieur.getAbonnement().getTypeAbon()== typeAbonnement).collect(Collectors.toList());
        return skieurRepository.findByAbonnementTypeAbonJPQL(typeAbonnement);
    }
}
