package io.github.jperparas.resourcetrackerpwa.mappers;

import io.github.jperparas.resourcetrackerpwa.entities.PowerType;
import io.github.jperparas.resourcetrackerpwa.models.PowerTypeDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PowerTypeMapper {
    PowerType PowerTypeDTOToPowerType(PowerTypeDTO powerTypeDTO);
    PowerTypeDTO PowerTypeToPowerTypeDTO(PowerType powerType);
}
