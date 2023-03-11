package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.entities.TypeCours;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur,Long> {
    @Query("select s from skieurs s where s.abonnement.typeAbon = ?1")
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);
    List<Skieur> findByInscriptionsCoursTypeCours(TypeCours typeCours);




}
