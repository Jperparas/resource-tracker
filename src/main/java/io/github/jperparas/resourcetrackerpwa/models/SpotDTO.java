package io.github.jperparas.resourcetrackerpwa.models;

import io.github.jperparas.resourcetrackerpwa.entities.Gpu;
import io.github.jperparas.resourcetrackerpwa.entities.Pca;
import lombok.Data;

import java.util.Set;
@Data
public class SpotDTO {

    private int id;
    private String name;
    private boolean hasChocks;
    private Set<GpuDTO> gpus;
    private Set<PcaDTO> pcas;
}
