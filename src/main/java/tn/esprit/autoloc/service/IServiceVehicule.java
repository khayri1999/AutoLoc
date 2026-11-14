package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;

public interface IServiceVehicule {
    List<Vehicule> retrieveAllVehicules();
    Vehicule retrieveVehicule(Long idVehicule);
    Vehicule addVehicule(Vehicule vehicule);
    void removeVehicule(Long idVehicule);
    Vehicule modifyVehicule(Vehicule vehicule);
}