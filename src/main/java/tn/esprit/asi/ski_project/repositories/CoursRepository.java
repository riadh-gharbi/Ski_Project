package tn.esprit.asi.ski_project.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.asi.ski_project.entities.Cours;
import tn.esprit.asi.ski_project.entities.Support;

import java.util.List;

public interface CoursRepository extends CrudRepository<Cours,Long> {
    List<Cours> findBySupport(Support support);

}
