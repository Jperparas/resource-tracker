package io.github.jperparas.resourcetrackerpwa.models;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PcaLogDTO {
    Long pcaLogId;
    LocalDateTime timestamp;
    LogType logType;
    PcaDTO pca;
    int resourceLevel;
    SpotDTO oldSpot;
    SpotDTO newSpot;
    String note;
}
