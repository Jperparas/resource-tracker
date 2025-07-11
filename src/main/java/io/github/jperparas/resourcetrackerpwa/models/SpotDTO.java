package io.github.jperparas.resourcetrackerpwa.models;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class SpotDTO {

    private int id;
    private String name;
    private Boolean hasAircraft;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer gpuCount;

}
