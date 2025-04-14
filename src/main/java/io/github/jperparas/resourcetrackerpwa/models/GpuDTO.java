package io.github.jperparas.resourcetrackerpwa.models;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class GpuDTO {
    private int id;
    private String gpuNumber;
    private Boolean powered;
    private SpotDTO spot;
    private PowerTypeDTO powerType;
    private Byte resourceLevel;
    private Byte defBlueLevel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
