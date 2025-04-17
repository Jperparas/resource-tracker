package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;

import java.util.List;

public interface GpuLogService {
     GpuLogDTO recordGpuLogById(int id, GpuDTO gpuDTO, String notes);

     List<GpuLogDTO> listGpuLogs();

     List<GpuLogDTO> listGpuLogs(Integer gpuID);
}


