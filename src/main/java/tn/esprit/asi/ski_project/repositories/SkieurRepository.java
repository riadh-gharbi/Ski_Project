package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.entities.TypeCours;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {

    //Keyword
    // List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);
    //JPQL Query
    @Query("select s from skieurs s where s.abonnement.typeAbon = ?1")
    List<Skieur> findByAbonnementTypeAbonJPQL(TypeAbonnement typeAbonnement);



    //Native SQL query of the same above method
    @Query(value = "SELECT * FROM skieurs s join abonnements a on s.abonnement_num_abon = a.num_abon " +
            "Where a.type_abonnement = :typeAbonnement", nativeQuery = true)
    List<Skieur> findByAbonnementTypeSQL(@Param("typeAbonnement") TypeAbonnement typeAbonnement);

    List<Skieur> findByInscriptionsCoursTypeCours(TypeCours typeCours);



    //SQL
    @Query(value = "select * from  skieurs s ORDER BY (SELECT COUNT(*) " +
            "from inscriptions i where i.skieur_num_skieur = s.num_skieur" , nativeQuery = true)
    List<Skieur> findSkieurOrderByNumInscriptionSQL();


//JPQL
    @Query("select s from skieurs s order by s.inscriptions.size")
    List<Skieur> findSkieurOrderByNumInscriptionJPQL();

}
