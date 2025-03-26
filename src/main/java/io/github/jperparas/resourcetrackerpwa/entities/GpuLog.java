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
@Table(name = "gpu_logs")
public class GpuLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gpuLogId;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    @Column(name = "log_type")
    private LogType logType;
    @ManyToOne
    @JoinColumn(name = "gpu_id")
    private Gpu gpu;
    @Column(name = "resource_level")
    private Byte resourceLevel;
    @Column(name = "def_blue_level", nullable = true)
    private Byte defBlueLevel;
    @ManyToOne
    @JoinColumn(name = "old_spot_id")
    private Spot oldSpot;
    @ManyToOne
    @JoinColumn(name = "new_spot_id")
    private Spot newSpot;
    @Column(name = "notes")
    private String note;
}
