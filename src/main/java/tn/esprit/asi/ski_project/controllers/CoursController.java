package tn.esprit.asi.ski_project.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Cours;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.services.ICoursService;

import java.util.List;

@RestController
@RequestMapping("/cours")
@RequiredArgsConstructor
public class CoursController {


    private final ICoursService coursService;

    @PostMapping()
    public Cours addCours(@RequestBody Cours cours) //requestBody : tell the program to look at the body of the http request for a skieur object (in the JSON data)
    {
        coursService.add(cours);
        return cours;
    }

    @GetMapping()
    public List<Cours> getAllCours(){
        return coursService.getAll();
    }

    @PutMapping()
    public Cours updateCours(@RequestBody Cours cours){
        coursService.update(cours);
        return cours;
    }

    @GetMapping("/{id}")
    public Cours getCours(@PathVariable("id")Long id) {
        return coursService.getById(id);
    }

    @DeleteMapping
    public void deleteCours(@RequestBody Cours cours) {
        coursService.remove(cours.getNumCours());
    }

}
