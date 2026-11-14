package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceVehicule implements IServiceVehicule {

    VehiculeRepository vehiculeRepository;
    VehiculeValidator vehiculeValidator;
    JournalisationService journalisationService;

    @Override
    public List<Vehicule> retrieveAllVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule retrieveVehicule(Long idVehicule) {
        return vehiculeRepository.findById(idVehicule).orElse(null);
    }

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        vehiculeValidator.valider(vehicule);
        journalisationService.info("Ajout du véhicule " + vehicule.getImmatriculation());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void removeVehicule(Long idVehicule) {
        journalisationService.info("Suppression du véhicule " + idVehicule);
        vehiculeRepository.deleteById(idVehicule);
    }

    @Override
    public Vehicule modifyVehicule(Vehicule vehicule) {
        vehiculeValidator.valider(vehicule);
        journalisationService.info("Modification du véhicule " + vehicule.getIdVehicule());
        return vehiculeRepository.save(vehicule);
    }
}