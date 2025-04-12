package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.mappers.SpotMapper;
import io.github.jperparas.resourcetrackerpwa.mappers.SpotTimestampMapper;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.SpotRepository;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestampDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService {
    private final SpotRepository spotRepository;
    private final SpotMapper spotMapper;
    private final SpotTimestampMapper spotTimestampMapper;

    @Override
    public List<SpotDTO> listSpots() {
        return spotRepository.findAll().stream().map(spotMapper::spotToSpotDto).collect(Collectors.toList());
    }

    @Override
    public List<SpotDTO> listSpotsByGpuCount() {
        return spotRepository.findAllByGpu().stream().map(spotMapper::spotToSpotDto).collect(Collectors.toList());
    }

    @Override
    public Optional<SpotDTO> getSpot(int id) {

        return Optional.ofNullable(spotMapper.spotToSpotDto(spotRepository.findById(id).orElse(null)));
    }

    @Override
    public List<SpotTimestampDTO> listSpotTimestamps() {
        return spotRepository.findAllWithTimestamp().stream()
                .map(spotTimestampMapper::spotTimestampToSpotTimestampDTO).collect(Collectors.toList());
    }

    @Override
    public List<SpotTimestampDTO> listByElapsedTime() {
        return spotRepository.findAllSpotsSortedByTimestamp().stream()
                .map(spotTimestampMapper::spotTimestampToSpotTimestampDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<LocalDateTime> getLastVisitedTime(int id) {
        return spotRepository.findLastVisitedById(id);
    }

    @Override
    public Optional<Integer> getGpuCount(int id) {
        return spotRepository.getGpuCountById(id);
    }
}
