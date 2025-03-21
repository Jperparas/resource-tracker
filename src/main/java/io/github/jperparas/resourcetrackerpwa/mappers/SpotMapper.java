package io.github.jperparas.resourcetrackerpwa.mappers;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import org.mapstruct.Mapper;

@Mapper
public interface SpotMapper {
    Spot SpotDtoToSpot(Spot spotDto);
    SpotDTO SpotToSpotDto(Spot spot);
}
