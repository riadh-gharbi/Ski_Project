package tn.esprit.asi.ski_project.services;

import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.entities.Moniteur;
import tn.esprit.asi.ski_project.entities.Support;

import java.util.List;

public interface IMoniteurService {
    void add(Moniteur a);
    Moniteur update(Moniteur a);
    List<Moniteur> getAll();
    Moniteur getById(long id);
    void remove(long id);
    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor,

                                                      Support support);
    Moniteur addMoniteurAndAssignToCourse(Moniteur moniteur,Long numCours);
}
