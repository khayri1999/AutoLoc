package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IServiceAgence;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    IServiceAgence serviceAgence;

    @GetMapping("/retrieve-all-agences")
    public List<Agence> getAgences() {
        return serviceAgence.retrieveAllAgences();
    }

    @GetMapping("/retrieve-agence/{agence-id}")
    public Agence retrieveAgence(@PathVariable("agence-id") Long id) {
        return serviceAgence.retrieveAgence(id);
    }

    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence agence) {
        return serviceAgence.addAgence(agence);
    }

    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long id) {
        serviceAgence.removeAgence(id);
    }

    @PutMapping("/modify-agence")
    public Agence modifyAgence(@RequestBody Agence agence) {
        return serviceAgence.modifyAgence(agence);
    }
}