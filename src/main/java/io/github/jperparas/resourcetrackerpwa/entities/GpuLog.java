package io.github.jperparas.resourcetrackerpwa.entities;

import io.github.jperparas.resourcetrackerpwa.models.LogType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="gpu_logs")
public class GpuLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long gpuLogId;
    @Column(name="timestamp")
    LocalDateTime timestamp;
    @Column(name="change_type")
    LogType logType;
    @ManyToOne
    @JoinColumn(name="gpu_id")
    Gpu gpu;
    @Column(name="resource_level")
    int resourceLevel;
    @Column(name="def_blue_level", nullable=true)
    Integer defBlueLevel;
    @ManyToOne
    @JoinColumn(name="old_spot_id")
    Spot oldSpot;
    @ManyToOne
    @JoinColumn(name="new_spot_id")
    Spot newSpot;
    @Column(name="notes")
    String note;
}
