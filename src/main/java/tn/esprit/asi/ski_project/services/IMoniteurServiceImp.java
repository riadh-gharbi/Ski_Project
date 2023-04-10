package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Cours;
import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.entities.Moniteur;
import tn.esprit.asi.ski_project.entities.Support;
import tn.esprit.asi.ski_project.repositories.CoursRepository;
import tn.esprit.asi.ski_project.repositories.InscriptionRepository;
import tn.esprit.asi.ski_project.repositories.MoniteurRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class IMoniteurServiceImp implements IMoniteurService {

    @Autowired
    private MoniteurRepository moniteurRepository;
    @Autowired
    private InscriptionRepository inscriptionRepository;
    @Autowired
    private CoursRepository coursRepository;
    @Override
    public void add(Moniteur m) {
        moniteurRepository.save(m);
    }

    @Override
    public Moniteur update(Moniteur m) {
        return moniteurRepository.save(m);
    }

    @Override
    public List<Moniteur> getAll() {
        return (List<Moniteur>) moniteurRepository.findAll();
    }

    @Override
    public Moniteur getById(long id) {
        return moniteurRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        moniteurRepository.deleteById(id);

    }
    public Map<Cours,List<Integer>> mapWeeksCourseOfInstructorBySupport(Long numInstructor, Support support)
    {
        return getById(numInstructor)
                .getCoursList()
                .stream()
                .filter(cours -> cours.getSupport().equals(support) )
                .map(cours -> cours.getInscriptions())
                .flatMap(Collection::stream)
             //   .map(Inscription::getNumSemaine)
              //   .collect(Collectors.toList());

                .collect(Collectors.groupingBy
                        (
                                Inscription::getCours,
                                Collectors.mapping(Inscription::getNumSemaine,Collectors.toList())

                        ));
    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
       return getById(numInstructor).getCoursList().stream()
               .flatMap(cours -> cours.getInscriptions().stream()).map(Inscription::getNumSemaine).collect(Collectors.toList());
    }

    @Override
    public Moniteur addMoniteurAndAssignToCourse(Moniteur moniteur, Long numCours) {

        Cours c = coursRepository.findById(numCours).orElse(null);
        if (c !=null)
        {
            moniteur.getCoursList().add(c);
            add(moniteur);
            return moniteur;

        }
        return null;
    }
}
