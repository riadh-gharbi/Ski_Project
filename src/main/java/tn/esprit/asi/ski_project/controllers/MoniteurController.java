package tn.esprit.asi.ski_project.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Moniteur;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.services.IMoniteurService;

import java.util.List;

@RestController
@RequestMapping("/moniteur")
@RequiredArgsConstructor
public class MoniteurController {

    private final IMoniteurService moniteurService;

    @PostMapping()
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur) //requestBody : tell the program to look at the body of the http request for a skieur object (in the JSON data)
    {
        moniteurService.add(moniteur);
        return moniteur;
    }

    @GetMapping()
    public List<Moniteur> getAllMoniteur(){
        return moniteurService.getAll();
    }

    @PutMapping()
    public Moniteur updateMoniteur(@RequestBody Moniteur moniteur){
        moniteurService.update(moniteur);
        return moniteur;
    }

    @GetMapping("/{id}")
    public Moniteur getMoniteur(@PathVariable("id")Long id) {
        return moniteurService.getById(id);
    }

    @DeleteMapping
    public void deleteMoniteur(@RequestBody Moniteur moniteur) {
        moniteurService.remove(moniteur.getNumMoniteur());
    }



}
