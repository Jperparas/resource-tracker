package io.github.jperparas.resourcetrackerpwa.mappers;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestamp;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestampDTO;

import org.mapstruct.Mapper;



@Mapper(uses = {SpotMapper.class})
public interface SpotTimestampMapper {


   default SpotTimestampDTO spotTimestampToSpotTimestampDTO(SpotTimestamp projection){
           if (projection == null) return null;

           return SpotTimestampDTO.builder()
                   .spotDTO(spotToSpotDto(projection.getSpot()))
                   .timestamp(projection.getTimestamp())
                   .build();
   }

    SpotDTO spotToSpotDto(Spot spot);
}
