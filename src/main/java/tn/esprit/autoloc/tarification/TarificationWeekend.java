package tn.esprit.autoloc.tarification;

import org.springframework.stereotype.Component;

@Component("weekend")
public class TarificationWeekend implements StrategieTarification {

    @Override
    public double calculer(double tarifJournalier, int jours) {
        return tarifJournalier * jours * 0.90;
    }
}