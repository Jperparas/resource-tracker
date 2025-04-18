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
    private GpuDTO gpu;
    private Byte resourceLevel;
    private Byte defBlueLevel;
    private SpotDTO oldSpot;
    private SpotDTO newSpot;
    private String note;

}
