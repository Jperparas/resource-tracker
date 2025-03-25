package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SpotService {
    List<SpotDTO> listSpots();
    Optional<SpotDTO> getSpot(int id);
    List<SpotTimestamp> listByElapsedTime();
    Optional<LocalDateTime> getLastVisitedTime(int id);
    Optional<Integer> getGpuCount(int id);
}
