package tn.esprit.autoloc.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IServiceEmploye;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeController {

    IServiceEmploye serviceEmploye;

    @GetMapping("/retrieve-all-employes")
    public List<Employe> getEmployes() {
        return serviceEmploye.retrieveAllEmployes();
    }

    @GetMapping("/retrieve-employe/{employe-id}")
    public Employe retrieveEmploye(@PathVariable("employe-id") Long id) {
        return serviceEmploye.retrieveEmploye(id);
    }

    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe employe) {
        return serviceEmploye.addEmploye(employe);
    }

    @DeleteMapping("/remove-employe/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") Long id) {
        serviceEmploye.removeEmploye(id);
    }

    @PutMapping("/modify-employe")
    public Employe modifyEmploye(@RequestBody Employe employe) {
        return serviceEmploye.modifyEmploye(employe);
    }

    @PutMapping("/affecter-employe/{employe-id}/{agence-id}")
    public Employe affecterEmploye(@PathVariable("employe-id") Long idEmploye,
                                   @PathVariable("agence-id") Long idAgence) {
        return serviceEmploye.affecterEmploye(idEmploye, idAgence);
    }

    @PutMapping("/desaffecter-employe/{employe-id}")
    public Employe desaffecterEmploye(@PathVariable("employe-id") Long idEmploye) {
        return serviceEmploye.desaffecterEmploye(idEmploye);
    }
}