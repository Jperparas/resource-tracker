package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;

import java.util.List;
import java.util.Optional;

public interface GpuService {
    List<GpuDTO> listGpus();

    GpuDTO saveNewGpu(GpuDTO gpu);

    Boolean deleteGpu(Integer gpuId);

    Optional<GpuDTO> getGpu(int id);

    Optional<GpuDTO> updateGpuById(int id, GpuDTO gpuDTO);

    Optional<GpuDTO> patchGpuById(int id, GpuDTO gpuDTO);
}
