package io.github.jperparas.resourcetrackerpwa.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GpuDTO {
   private int id;
   private String gpuNumber;
   private Boolean isPoweredOn;
   private SpotDTO spot;
   private PowerTypeDTO powerType;
   private Byte resourceLevel;
   private Byte defBlueLevel;


}
