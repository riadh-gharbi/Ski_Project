package tn.esprit.asi.ski_project.services;

import tn.esprit.asi.ski_project.entities.Piste;

import java.util.List;

public interface IPisteService {
    void add(Piste a);
    Piste update(Piste a);
    List<Piste> getAll();
    Piste getById(long id);
    void remove(long id);

}
