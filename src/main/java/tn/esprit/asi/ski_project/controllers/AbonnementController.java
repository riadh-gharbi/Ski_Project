package tn.esprit.asi.ski_project.controllers;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Abonnement;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.entities.TypeAbonnement;
import tn.esprit.asi.ski_project.services.IAbonnementService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/abon")
@RequiredArgsConstructor
public class AbonnementController {
    //@Autowired
    private final IAbonnementService abonnementService;

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

    @GetMapping("/type")
    public Set<Abonnement> getByType(@RequestBody TypeAbonnement typeAbonnement)
    {
        return abonnementService.getSubscriptionByType(typeAbonnement);
    }


    //DateTimeFormat to fix a certain pattern
    @GetMapping("/{startDate}/{endDate}")
    public Set<Abonnement> getAbonBetweenDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate)
    {
        return abonnementService.retrieveSubscriptionsByDates(startDate,endDate);
    }

}
