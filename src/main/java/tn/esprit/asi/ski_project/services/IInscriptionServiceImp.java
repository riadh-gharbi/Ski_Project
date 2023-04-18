package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Cours;
import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.entities.TypeCours;
import tn.esprit.asi.ski_project.repositories.CoursRepository;
import tn.esprit.asi.ski_project.repositories.InscriptionRepository;
import tn.esprit.asi.ski_project.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IInscriptionServiceImp implements IInscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private SkieurRepository skieurRepository;
    @Override
    public void add(Inscription i) {
        inscriptionRepository.save(i);
    }

    @Override
    public Inscription update(Inscription i) {
        return inscriptionRepository.save(i);
    }

    @Override
    public List<Inscription> getAll() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    @Override
    public Inscription getById(long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        inscriptionRepository.deleteById(id);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        //Conditions
        //if (((List<Skieur>)skieurRepository.findAll()).stream().filter(skieur -> skieur.getInscriptions()))

        Skieur s = skieurRepository.findById(numSkieur).orElse(null);
        Cours c = coursRepository.findById(numCours).orElse(null);
        if (c != null && s != null ){
            if (Period.between(s.getDateNaissance(),LocalDate.now()).getYears() >=18 && c.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE)
                    || Period.between(s.getDateNaissance(),LocalDate.now()).getYears()< 18 && c.getTypeCours().equals(TypeCours.COLLECTIF_ENFANT)) {
                if (c.getInscriptions().stream().count() < 6 && s.getInscriptions().stream().count()<6)
                {
                    s.getInscriptions().add(inscription);
                    c.getInscriptions().add(inscription);
                }
            }
            s.getInscriptions().add(inscription);
            c.getInscriptions().add(inscription);
        }

        return null;
    }
}
