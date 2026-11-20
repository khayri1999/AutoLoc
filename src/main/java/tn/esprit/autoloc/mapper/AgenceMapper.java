package tn.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.web.dto.AgenceDTO;
import tn.esprit.autoloc.web.dto.AgenceRequestDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgenceMapper {

    // Entité -> DTO de réponse
    AgenceDTO toDto(Agence agence);

    List<AgenceDTO> toDtoList(List<Agence> agences);

    // DTO reçu -> nouvelle entité (ajout)
    @Mapping(target = "idAgence", ignore = true)
    @Mapping(target = "vehicules", ignore = true)
    @Mapping(target = "employes", ignore = true)
    Agence toEntity(AgenceRequestDTO dto);

    // Copie le DTO dans une entité existante (modification)
    @Mapping(target = "idAgence", ignore = true)
    @Mapping(target = "vehicules", ignore = true)
    @Mapping(target = "employes", ignore = true)
    void updateEntity(AgenceRequestDTO dto, @MappingTarget Agence agence);
}