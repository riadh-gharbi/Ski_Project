package tn.esprit.asi.ski_project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.asi.ski_project.entities.Piste;
import tn.esprit.asi.ski_project.entities.Skieur;
import tn.esprit.asi.ski_project.services.IPisteService;
import tn.esprit.asi.ski_project.services.ISkieurService;

import java.util.List;

@RestController
//The front end will use the /skieur path
@RequestMapping("/piste")
@RequiredArgsConstructor
public class PisteController {
    private final IPisteService pisteService;

    @PostMapping()
    public Piste addPiste(@RequestBody Piste piste) //requestBody : tell the program to look at the body of the http request for a skieur object (in the JSON data)
    {
        pisteService.add(piste);
        return piste;
    }

    @GetMapping()
    public List<Piste> getAllPiste(){
        return pisteService.getAll();
    }

    @PutMapping()
    public Piste updatePiste(@RequestBody Piste piste){
        pisteService.update(piste);
        return piste;
    }

    @GetMapping("/{id}")
    public Piste getPiste(@PathVariable("id")Long id) {
        return pisteService.getById(id);
    }

    @DeleteMapping
    public void deletePiste(@RequestBody Piste piste) {
        pisteService.remove(piste.getNumPiste());
    }

}
