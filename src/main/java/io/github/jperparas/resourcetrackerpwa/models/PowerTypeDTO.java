package io.github.jperparas.resourcetrackerpwa.models;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PowerTypeDTO {
    private int powerTypeId;
    private String name;
}
