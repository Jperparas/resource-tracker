package io.github.jperparas.resourcetrackerpwa.models;

import io.github.jperparas.resourcetrackerpwa.entities.Pca;
import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import lombok.Data;

import java.time.LocalDateTime;
@Data
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
