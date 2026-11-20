package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.mapper.AgenceMapper;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.web.dto.AgenceDTO;
import tn.esprit.autoloc.web.dto.AgenceRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceAgence implements IServiceAgence {

    private final AgenceRepository agenceRepository;
    private final AgenceMapper agenceMapper;

    @Override
    public List<AgenceDTO> retrieveAllAgences() {
        return agenceMapper.toDtoList(agenceRepository.findAll());
    }

    @Override
    public AgenceDTO retrieveAgence(Long idAgence) {
        return agenceMapper.toDto(findAgence(idAgence));
    }

    @Override
    public AgenceDTO addAgence(AgenceRequestDTO dto) {
        Agence agence = agenceMapper.toEntity(dto);
        return agenceMapper.toDto(agenceRepository.save(agence));
    }

    @Override
    public void removeAgence(Long idAgence) {
        agenceRepository.deleteById(idAgence);
    }

    @Override
    @Transactional
    public AgenceDTO modifyAgence(Long idAgence, AgenceRequestDTO dto) {
        Agence agence = findAgence(idAgence);
        agenceMapper.updateEntity(dto, agence);
        return agenceMapper.toDto(agenceRepository.save(agence));
    }

    private Agence findAgence(Long idAgence) {
        return agenceRepository.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable : " + idAgence));
    }
}