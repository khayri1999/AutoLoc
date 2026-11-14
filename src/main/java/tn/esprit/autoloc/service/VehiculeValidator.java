package tn.esprit.autoloc.service;

import org.springframework.stereotype.Component;
import tn.esprit.autoloc.domain.Vehicule;

import java.math.BigDecimal;

@Component
public class VehiculeValidator {

    public void valider(Vehicule vehicule) {
        BigDecimal tarif = vehicule.getTarifJournalier();
        if (tarif == null || tarif.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Le tarif doit être positif");
        }
    }
}