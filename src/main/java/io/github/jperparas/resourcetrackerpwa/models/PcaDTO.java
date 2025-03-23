package io.github.jperparas.resourcetrackerpwa.models;

import lombok.Data;

@Data
public class PcaDTO {
    private int id;
    private String pcaNumber;
    private SpotDTO spot;
    private PowerTypeDTO powerType;
    private Byte resourceLevel;
}
