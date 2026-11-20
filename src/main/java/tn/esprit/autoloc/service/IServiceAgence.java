package tn.esprit.autoloc.service;

import tn.esprit.autoloc.web.dto.AgenceDTO;
import tn.esprit.autoloc.web.dto.AgenceRequestDTO;

import java.util.List;

public interface IServiceAgence {

    List<AgenceDTO> retrieveAllAgences();

    AgenceDTO retrieveAgence(Long idAgence);

    AgenceDTO addAgence(AgenceRequestDTO dto);

    void removeAgence(Long idAgence);

    AgenceDTO modifyAgence(Long idAgence, AgenceRequestDTO dto);
}