package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import io.github.jperparas.resourcetrackerpwa.mappers.SpotMapper;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService {
    private final SpotRepository spotRepository;
    private final SpotMapper spotMapper;


    @Override
    public List<SpotDTO> listSpots() {
        return spotRepository.findAll().stream().map(this::mapSpotWithGpuCount).collect(Collectors.toList());
    }

    @Override
    public List<SpotDTO> listSpotsByGpuCount() {
        return spotRepository.findAllByGpu().stream().map(this::mapSpotWithGpuCount).collect(Collectors.toList());
    }

    @Override
    public List<SpotDTO> listByLastUpdate() {
        return spotRepository.findAllByOrderByUpdatedAt().stream().map(this::mapSpotWithGpuCount).collect(Collectors.toList());
    }
    @Override
    public Optional<SpotDTO> getSpot(int id) {
        return spotRepository.findById(id).map(this::mapSpotWithGpuCount);
    }
    private SpotDTO mapSpotWithGpuCount(Spot spot) {
        SpotDTO dto = spotMapper.spotToSpotDto(spot);
        dto.setGpuCount(getGpuCount(spot.getId()).orElse(0)); // Add GPU count
        return dto;
    }

    @Override
    public SpotDTO saveNewSpot(SpotDTO spot) {
        return spotMapper.spotToSpotDto(spotRepository.save(spotMapper.spotDtoToSpot(spot)));
    }

    @Override
    public Boolean deleteSpotById(Integer spotId) {
        if (spotRepository.existsById(spotId)) {
            spotRepository.deleteById(spotId);
            return true;
        }
        return false;
    }

    @Override
    public Optional<SpotDTO> updateSpotById(Integer spotId, SpotDTO spot) {
        AtomicReference<Optional<SpotDTO>> atomicReference = new AtomicReference<>();

        spotRepository.findById(spotId).ifPresentOrElse(foundSpot -> {
            foundSpot.setHasAircraft(spot.getHasAircraft());
            foundSpot.setName(spot.getName());
            atomicReference.set(Optional.of(spotMapper
                    .spotToSpotDto(spotRepository.save(foundSpot))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }

    @Override
    public Optional<SpotDTO> patchSpotById(Integer spotId, SpotDTO spot) {
        AtomicReference<Optional<SpotDTO>> atomicReference = new AtomicReference<>();

        spotRepository.findById(spotId).ifPresentOrElse(foundSpot -> {
            if (spot.getHasAircraft() != null)
                foundSpot.setHasAircraft(spot.getHasAircraft());
            if (spot.getName() != null)
                foundSpot.setName(spot.getName());

            atomicReference.set(Optional.of(spotMapper
                    .spotToSpotDto(spotRepository.save(foundSpot))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }


    @Override
    public Optional<Integer> getGpuCount(int id) {
        return spotRepository.getGpuCountById(id);
    }
}
