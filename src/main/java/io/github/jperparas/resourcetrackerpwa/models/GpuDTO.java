package io.github.jperparas.resourcetrackerpwa.models;

import lombok.Data;

@Data
public class GpuDTO {
   private int id;
   private String gpuNumber;
   private SpotDTO spot;
   private PowerTypeDTO powerType;
   private Byte resourceLevel;
   private Byte defBlueLevel;


}
