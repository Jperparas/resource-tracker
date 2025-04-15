package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;

import java.util.List;
import java.util.Optional;

public interface SpotService {
    List<SpotDTO> listSpots();

    List<SpotDTO> listSpotsByGpuCount();

    List<SpotDTO> listByLastUpdate();

    Optional<SpotDTO> getSpot(int id);

    Optional<Integer> getGpuCount(int id);
}
