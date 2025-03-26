package io.github.jperparas.resourcetrackerpwa.models;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GpuLogDTO {

    private Long gpuLogId;
    private LocalDateTime timestamp;
    private LogType logType;
    private GpuDTO gpuDto;
    private Byte resourceLevel;
    private Byte defBlueLevel;
    private SpotDTO oldSpotDto;
    private SpotDTO newSpotDto;
    private String note;

}
