package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;

public interface GpuLogService {
     GpuLogDTO recordGpuLogById(int id, GpuDTO gpuDTO, String notes);

}


