package tn.esprit.asi.ski_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.repositories.PisteRepository;

import java.util.List;

@Service
public class IPisteServiceImp implements  IPisteService{


    @Autowired
    PisteRepository pisteRepository;
    @Override
    public void add(Piste a) {
        pisteRepository.save(a);
    }

    @Override
    public Piste update(Piste a) {
        return pisteRepository.save(a);
    }

    @Override
    public List<Piste> getAll() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Piste getById(long id) {
        return pisteRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(long id) {
        pisteRepository.deleteById(id);
    }
}
