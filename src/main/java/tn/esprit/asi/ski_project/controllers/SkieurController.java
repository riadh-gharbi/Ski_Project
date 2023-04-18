package tn.esprit.asi.ski_project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.services.ISkieurService;

import java.util.List;


//Exposition des services
//Pas d'implémentation
//Just takes care on how the service is exposed (annotations ,
@RestController
//The front end will use the /skieur path
@RequestMapping("/skieur")
@RequiredArgsConstructor
public class SkieurController {


    private final ISkieurService skieurService;

    @PostMapping()
    public Skieur addSkieur(@RequestBody Skieur skieur) //requestBody : tell the program to look at the body of the http request for a skieur object (in the JSON data)
    {
        skieurService.add(skieur);
        return skieur;
    }

    @GetMapping()
    public List<Skieur> getAllCours(){
        return skieurService.getAll();
    }

    @PutMapping()
    public Skieur updateSkieur(@RequestBody Skieur skieur){
        skieurService.update(skieur);
        return skieur;
    }

    @GetMapping("/{id}")
    public Skieur getSkieur(@PathVariable("id")Long id) {
        return skieurService.getById(id);
    }

    @DeleteMapping
    public void deleteSkieur(@RequestBody Skieur skieur) {
        skieurService.remove(skieur.getNumSkieur());
    }



    @PutMapping("/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable Long numSkieur,@PathVariable Long numPiste)
    {
        return skieurService.assignSkieurToPiste(numSkieur,numPiste);
    }

    @PutMapping("/abon/{numSkieur}/{numAbon}")
    public Skieur assignSkieurToAbon(@PathVariable Long numSkieur, @PathVariable Long numAbon){
        return skieurService.assignSkieurToAbon(numSkieur,numAbon);
    }

    @PostMapping("/addSkieurCourse")
    public Skieur addSkierAndAssignToCourse(@RequestBody Skieur s)
    {
        return skieurService.addSkierAndAssignToCourse(s);
    }


}
