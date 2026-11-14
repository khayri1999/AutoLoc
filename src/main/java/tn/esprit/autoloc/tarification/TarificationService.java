package tn.esprit.autoloc.tarification;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TarificationService {

    private final Map<String, StrategieTarification> strategies;

    public TarificationService(Map<String, StrategieTarification> strategies) {
        this.strategies = strategies;
    }

    public double calculer(String type, double tarifJournalier, int jours) {
        if (jours <= 0) {
            throw new IllegalArgumentException("Le nombre de jours doit être positif");
        }
        StrategieTarification strategie = strategies.get(type);
        if (strategie == null) {
            throw new IllegalArgumentException(
                    "Type de tarif inconnu : " + type + ". Types disponibles : " + strategies.keySet());
        }
        return strategie.calculer(tarifJournalier, jours);
    }
}