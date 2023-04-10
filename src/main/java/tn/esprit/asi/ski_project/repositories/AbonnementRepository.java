package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    @Query("select a from abonnements a where a.typeAbon = ?1")
    Set<Abonnement> findByTypeAbon(TypeAbonnement typeAbonnement);
    Set<Abonnement> findByDateDebutBetween(LocalDate startDate, LocalDate endDate);
}
