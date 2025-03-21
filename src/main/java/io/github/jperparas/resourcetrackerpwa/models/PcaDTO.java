package io.github.jperparas.resourcetrackerpwa.models;

import lombok.Data;

@Data
public class PcaDTO {
    private int Id;
    private String pcaNumber;
    private SpotDTO spot;
    private PowerTypeDTO powerType;
    private byte resourceLevel;
}
