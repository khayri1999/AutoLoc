package tn.esprit.autoloc.web.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IServiceVehicule;
import tn.esprit.autoloc.tarification.TarificationService;

import java.util.List;

@Tag(name = "Gestion Vehicule")
@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeController {

    IServiceVehicule serviceVehicule;
    TarificationService tarificationService;

    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> getVehicules() {
        return serviceVehicule.retrieveAllVehicules();
    }

    @GetMapping("/retrieve-vehicule/{vehicule-id}")
    public Vehicule retrieveVehicule(@PathVariable("vehicule-id") Long idVehicule) {
        return serviceVehicule.retrieveVehicule(idVehicule);
    }

    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule vehicule) {
        return serviceVehicule.addVehicule(vehicule);
    }

    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long idVehicule) {
        serviceVehicule.removeVehicule(idVehicule);
    }

    @PutMapping("/modify-vehicule")
    public Vehicule modifyVehicule(@RequestBody Vehicule vehicule) {
        return serviceVehicule.modifyVehicule(vehicule);
    }

    @GetMapping("/calculer-tarif/{vehicule-id}")
    public double calculerTarif(@PathVariable("vehicule-id") Long idVehicule,
                                @RequestParam("type") String type,
                                @RequestParam("jours") int jours) {
        Vehicule vehicule = serviceVehicule.retrieveVehicule(idVehicule);
        if (vehicule == null) {
            throw new IllegalArgumentException("Véhicule introuvable : " + idVehicule);
        }
        return tarificationService.calculer(type, vehicule.getTarifJournalier().doubleValue(), jours);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}