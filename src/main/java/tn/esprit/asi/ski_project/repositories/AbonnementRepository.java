package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.asi.ski_project.entities.Abonnement;

public interface AbonnementRepository extends CrudRepository<Abonnement,Long> {

}
