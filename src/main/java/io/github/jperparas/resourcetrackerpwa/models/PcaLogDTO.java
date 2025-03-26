package io.github.jperparas.resourcetrackerpwa.models;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PcaLogDTO {
    private Long pcaLogId;
    private LocalDateTime timestamp;
    private LogType logType;
    private PcaDTO pca;
    private Byte resourceLevel;
    private SpotDTO oldSpot;
    private SpotDTO newSpot;
    private String note;
}
