package tn.esprit.asi.ski_project.services;

import tn.esprit.asi.ski_project.entities.Cours;

import java.util.List;

public interface ICoursService {
    void add(Cours a);
    Cours update(Cours a);
    List<Cours> getAll();
    Cours getById(long id);
    void remove(long id);
}
