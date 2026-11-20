package tn.esprit.autoloc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.service.IServiceAgence;
import tn.esprit.autoloc.web.dto.AgenceDTO;
import tn.esprit.autoloc.web.dto.AgenceRequestDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agence")
public class AgenceController {

    private final IServiceAgence serviceAgence;

    @GetMapping("/retrieve-all-agences")
    public List<AgenceDTO> getAgences() {
        return serviceAgence.retrieveAllAgences();
    }

    @GetMapping("/retrieve-agence/{agence-id}")
    public AgenceDTO retrieveAgence(@PathVariable("agence-id") Long id) {
        return serviceAgence.retrieveAgence(id);
    }

    @PostMapping("/add-agence")
    public AgenceDTO addAgence(@Valid @RequestBody AgenceRequestDTO dto) {
        return serviceAgence.addAgence(dto);
    }

    @PutMapping("/modify-agence/{agence-id}")
    public AgenceDTO modifyAgence(@PathVariable("agence-id") Long id,
                                  @Valid @RequestBody AgenceRequestDTO dto) {
        return serviceAgence.modifyAgence(id, dto);
    }

    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long id) {
        serviceAgence.removeAgence(id);
    }
}