package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import java.util.List;

public interface IServiceEmploye {

    List<Employe> retrieveAllEmployes();

    Employe retrieveEmploye(Long idEmploye);

    Employe addEmploye(Employe employe);

    void removeEmploye(Long idEmploye);

    Employe modifyEmploye(Employe employe);

    Employe affecterEmploye(Long idEmploye, Long idAgence);

    Employe desaffecterEmploye(Long idEmploye);
}