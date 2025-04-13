package io.github.jperparas.resourcetrackerpwa.models;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SpotDTO {

    private int id;
    private String name;
    private Boolean hasAircraft;

}
