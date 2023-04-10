package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.asi.ski_project.entities.Inscription;
import tn.esprit.asi.ski_project.entities.Support;

import java.util.List;

public interface InscriptionRepository extends CrudRepository<Inscription,Long> {
    @Query("select i from inscriptions i where i.cours.support = ?1")
    List<Inscription> findByCours_Support(Support support);
}
