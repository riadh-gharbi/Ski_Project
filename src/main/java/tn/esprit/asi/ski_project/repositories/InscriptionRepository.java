package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.asi.ski_project.entities.Inscription;

public interface InscriptionRepository extends CrudRepository<Inscription,Long> {
}
