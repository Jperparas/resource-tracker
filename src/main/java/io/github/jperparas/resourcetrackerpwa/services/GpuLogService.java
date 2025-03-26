package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;

public interface GpuLogService {
    public GpuLogDTO recordGpuLog(GpuLogDTO gpuLogDTO);
    //TODO add methods for moving, powering on, powering off, and equipmentcheck

}
