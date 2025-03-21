package io.github.jperparas.resourcetrackerpwa.dtos;

import lombok.Data;

@Data
public class GpuDto {
   private int Id;
   private String gpuNumber;
   private SpotDto spot;
   private PowerTypeDto powerType;
   private byte resourceLevel;


}
