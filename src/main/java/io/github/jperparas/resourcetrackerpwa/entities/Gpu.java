package io.github.jperparas.resourcetrackerpwa.entities;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "gpus")
public class Gpu {
    @Id
    @Column(name = "gpu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name="spot_id")
    Spot spot;

    @Column(name="gpu_serial_number")
    String gpuNumber;

    @ManyToOne
    @JoinColumn(name="power_type_id")
    PowerType powerType;

    @Column(name="resource_level")
    byte resource_level;


}
