package tn.esprit.asi.ski_project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.services.IAbonnementService;

import java.util.List;

@RestController
@RequestMapping("/abon")
public class AbonnementController {

    @Autowired
    private IAbonnementService abonnementService;

    @PostMapping()
    public Abonnement addAbon(@RequestBody Abonnement abonnement) //requestBody : tell the program to look at the body of the http request for a skieur object (in the JSON data)
    {
        abonnementService.add(abonnement);
        return abonnement;
    }

    @GetMapping()
    public List<Abonnement> getAllAbonnement(){
        return abonnementService.getAll();
    }

    @PutMapping()
    public Abonnement updateAbonnnement(@RequestBody Abonnement abonnement){
        abonnementService.update(abonnement);
        return abonnement;
    }

    @GetMapping("/{id}")
    public Abonnement getAbonnement(@PathVariable("id")Long id) {
        return abonnementService.getById(id);
    }

    @DeleteMapping
    public void deleteAbonnement(@RequestBody Abonnement abonnement) {
        abonnementService.remove(abonnement.getNumAbon());
    }

}
