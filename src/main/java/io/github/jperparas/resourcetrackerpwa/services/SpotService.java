package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestampDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SpotService {
    List<SpotDTO> listSpots();

    List<SpotDTO> listSpotsByGpuCount();

    Optional<SpotDTO> getSpot(int id);

    List<SpotTimestampDTO> listSpotTimestamps();

    List<SpotTimestampDTO> listByElapsedTime();

    Optional<LocalDateTime> getLastVisitedTime(int id);

    Optional<Integer> getGpuCount(int id);
}
