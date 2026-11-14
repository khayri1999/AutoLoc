package tn.esprit.autoloc.tarification;

public interface StrategieTarification {
    double calculer(double tarifJournalier, int jours);
}
