package io.github.jperparas.resourcetrackerpwa.mappers;

import io.github.jperparas.resourcetrackerpwa.entities.Pca;
import io.github.jperparas.resourcetrackerpwa.models.PcaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PcaMapper {

    Pca PcaDTOToPca(PcaDTO pcaDTO);

    PcaDTO PcaToPcaDTO(Pca pca);
}
