package io.github.jperparas.resourcetrackerpwa.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spot_id")
    private Spot spot;

    @Column(name = "gpu_serial_number")
    private String gpuNumber;

    @Column(name = "is_powered", nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean powered;

    @ManyToOne
    @JoinColumn(name = "power_type_id")
    private PowerType powerType;

    @Column(name = "resource_level")
    private Byte resourceLevel;

    @Column(name = "created", updatable = false)
    private LocalDateTime createdAt;


    @Column(name = "updated")
    private LocalDateTime updatedAt;

    @Column(name = "def_blue_level")
    private Byte defBlueLevel;


    @PrePersist
    protected void onCreate() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        this.setUpdatedAt(LocalDateTime.now());
    }

}
