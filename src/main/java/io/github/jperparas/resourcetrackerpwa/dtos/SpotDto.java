package io.github.jperparas.resourcetrackerpwa.dtos;

import io.github.jperparas.resourcetrackerpwa.entities.Gpu;
import io.github.jperparas.resourcetrackerpwa.entities.Pca;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
public class SpotDto {

    private int id;
    private String name;
    private boolean hasChocks;
    private Set<Gpu> gpus;
    private Set<Pca> pcas;
}
