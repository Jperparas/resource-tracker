package io.github.jperparas.resourcetrackerpwa.dtos;

import lombok.Data;

@Data
public class PcaDto {
    private int Id;
    private String pcaNumber;
    private SpotDto spot;
    private PowerTypeDto powerType;
    private byte resourceLevel;
}
