package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.repositories.AbonnementRepository;
import tn.esprit.asi.ski_project.repositories.InscriptionRepository;
import tn.esprit.asi.ski_project.repositories.PisteRepository;
import tn.esprit.asi.ski_project.repositories.SkieurRepository;

import java.util.List;
import java.util.stream.Collectors;


//the @Service indicates to the project to create an instance of this class to be called by the Controller
//We don't need to do it in the repository because the Spring Data JPA takes care of it by scanning the project (explained down below)
@Service
public class ISkieurServiceImp implements ISkieurService {
    //Injection de dépendances
    //the skieur repo is empty without instance
    //Spring Data JPA is the one that creates the instance on runtime
    //It scans the project for Interfaces that extends from JPARepo or SortingAndPagination or CrudRepository
    //The instances are located in the project context in the form of beans
    //It injects the instance to the variable with autowired
    //It is a dependency which is injected inside the variable.
    @Autowired
    private SkieurRepository skieurRepository;
    @Autowired
    private PisteRepository pisteRepository;
    @Autowired
    private AbonnementRepository abonnementRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
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
    public Skieur assignSkieurToAbon(Long numSkieur, Long numAbon) {
        if(skieurRepository.existsById(numSkieur) && abonnementRepository.existsById(numAbon))
        {
            Skieur s = skieurRepository.findById(numSkieur).get();
            s.setAbonnement(abonnementRepository.findById(numAbon).get());
            return skieurRepository.save(s);
        }
        return null;
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur) {
        //Créer Abonnement
        Abonnement a = skieur.getAbonnement();
        if(a != null && skieur.getInscriptions() != null){
        abonnementRepository.save(a);
        inscriptionRepository.saveAll(skieur.getInscriptions());
        return skieurRepository.save(skieur);}
        return null;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        //return getAll().stream().filter(skieur -> skieur.getAbonnement().getTypeAbon()== typeAbonnement).collect(Collectors.toList());
        return skieurRepository.findByAbonnementTypeAbon(typeAbonnement);
    }
}
