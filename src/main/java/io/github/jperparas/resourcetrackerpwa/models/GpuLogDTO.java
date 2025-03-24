package io.github.jperparas.resourcetrackerpwa.models;

import io.github.jperparas.resourcetrackerpwa.entities.Gpu;
import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Builder
@Data
public class GpuLogDTO {

    Long gpuLogId;
    LocalDateTime timestamp;
    LogType logType;
    GpuDTO gpuDto;
    int resourceLevel;
    Integer defBlueLevel;
    SpotDTO oldSpotDto;
    SpotDTO newSpotDto;
    String note;

}
