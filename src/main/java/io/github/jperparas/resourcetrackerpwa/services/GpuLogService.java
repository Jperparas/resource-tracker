package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;
import io.github.jperparas.resourcetrackerpwa.models.LogType;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import org.springframework.lang.Nullable;

public interface GpuLogService {
    public GpuLogDTO recordGpuLog(GpuLogDTO gpuLogDTO);
   // public GpuLogDTO recordGpuLog(GpuDTO gpuDTO, LogType logType, @Nullable SpotDTO newSpot, @Nullable String note);

}


