package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.mappers.GpuMapper;
import io.github.jperparas.resourcetrackerpwa.mappers.PowerTypeMapper;
import io.github.jperparas.resourcetrackerpwa.mappers.SpotMapper;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.GpuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GpuServiceImpl implements GpuService {
    private final GpuRepository gpuRepository;
    private final GpuMapper gpuMapper;
    private final SpotMapper spotMapper;
    private final PowerTypeMapper powerTypeMapper;

    @Override
    public List<GpuDTO> listGpus() {
        return gpuRepository.findAll().stream().map(gpuMapper::GpuToGpuDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<GpuDTO> getGpu(int id) {
        return Optional.ofNullable(gpuMapper.GpuToGpuDTO(gpuRepository.findById(id).orElse(null)));
    }

    @Override
    public Optional<GpuDTO> updateGpuById(int id, GpuDTO gpuDTO) {
        AtomicReference<Optional<GpuDTO>> atomicReference = new AtomicReference<>();

        gpuRepository.findById(id).ifPresentOrElse(foundGpu -> {
                    foundGpu.setGpuNumber(gpuDTO.getGpuNumber());
                    foundGpu.setSpot(spotMapper.SpotDtoToSpot(gpuDTO.getSpot()));
                    foundGpu.setPowerType(powerTypeMapper.PowerTypeDTOToPowerType(gpuDTO.getPowerType()));
                    foundGpu.setResourceLevel(gpuDTO.getResourceLevel());
                    foundGpu.setDefBlueLevel(gpuDTO.getDefBlueLevel());
                    atomicReference.set(Optional.of(gpuMapper.GpuToGpuDTO(gpuRepository.save(foundGpu))));

                }, () -> {
                    atomicReference.set(Optional.empty());
                }
        );

        return atomicReference.get();
    }

    @Override
    public Optional<GpuDTO> patchGpuById(int id, GpuDTO gpuDTO) {
        AtomicReference<Optional<GpuDTO>> atomicReference = new AtomicReference<>();

        gpuRepository.findById(id).ifPresentOrElse(foundGpu -> {
                    if (StringUtils.hasText(gpuDTO.getGpuNumber())) {
                        foundGpu.setGpuNumber(gpuDTO.getGpuNumber());
                    }
                    if (gpuDTO.getSpot() != null) {
                        foundGpu.setSpot(spotMapper.SpotDtoToSpot(gpuDTO.getSpot()));
                    }
                    if (gpuDTO.getPowerType() != null) {
                        foundGpu.setPowerType(powerTypeMapper.PowerTypeDTOToPowerType(gpuDTO.getPowerType()));
                    }
                    if (gpuDTO.getResourceLevel() != null) {
                        foundGpu.setResourceLevel(gpuDTO.getResourceLevel());
                    }
                    if(gpuDTO.getDefBlueLevel()!=null) {
                        foundGpu.setDefBlueLevel(gpuDTO.getDefBlueLevel());
                    }
                    atomicReference.set(Optional.of(gpuMapper.GpuToGpuDTO(gpuRepository.save(foundGpu))));

                }, () -> {
                    atomicReference.set(Optional.empty());
                }
        );

        return atomicReference.get();

    }
}
