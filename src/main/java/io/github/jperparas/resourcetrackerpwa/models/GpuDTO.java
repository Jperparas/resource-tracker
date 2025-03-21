package io.github.jperparas.resourcetrackerpwa.models;

import lombok.Data;

@Data
public class GpuDTO {
   private int Id;
   private String gpuNumber;
   private SpotDTO spot;
   private PowerTypeDTO powerType;
   private byte resourceLevel;


}
