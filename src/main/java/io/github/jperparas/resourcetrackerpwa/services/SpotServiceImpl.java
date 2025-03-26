package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.mappers.SpotMapper;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.SpotRepository;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService {
    private final SpotRepository spotRepository;
    private final SpotMapper spotMapper;
    @Override
    public List<SpotDTO> listSpots() {
        return spotRepository.findAll().stream().map(spotMapper::SpotToSpotDto).collect(Collectors.toList());
    }

    @Override
    public Optional<SpotDTO> getSpot(int id) {

        return Optional.ofNullable(spotMapper.SpotToSpotDto(spotRepository.findById(id).orElse(null)));
    }

    @Override
    public List<SpotTimestamp> listSpotTimestamps() {
        return new ArrayList<>(spotRepository.findAllWithTimestamp());
    }

    @Override
    public List<SpotTimestamp> listByElapsedTime() {
        return new ArrayList<>(spotRepository.findAllSpotsSortedByTimestamp());
    }

    @Override
    public Optional<LocalDateTime> getLastVisitedTime(int id) {
        return spotRepository.findLastVisitedById(id);
    }

    @Override
    public Optional<Integer> getGpuCount(int id) {return spotRepository.getGpuCountById(id);}
}
