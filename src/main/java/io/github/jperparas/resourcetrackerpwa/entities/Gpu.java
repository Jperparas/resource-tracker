package io.github.jperparas.resourcetrackerpwa.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    private int id;

    @ManyToOne
    @JoinColumn(name="spot_id")
    private Spot spot;

    @Column(name="gpu_serial_number")
    private String gpuNumber;
    @Column(name="is_powered_on")
    private Boolean isPoweredOn;

    @ManyToOne
    @JoinColumn(name="power_type_id")
    private PowerType powerType;

    @Column(name="resource_level")
    private Byte resourceLevel;

    @Column(name="def_blue_level")
    private Byte DefBlueLevel;
    @OneToMany(mappedBy = "gpu")
    Set<GpuLog> gpuLogs;

}
