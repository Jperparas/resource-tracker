package io.github.jperparas.resourcetrackerpwa.models;

import lombok.Data;

@Data
public class GpuUpdateRequest {
    GpuDTO gpuDTO;
    String note;

}
