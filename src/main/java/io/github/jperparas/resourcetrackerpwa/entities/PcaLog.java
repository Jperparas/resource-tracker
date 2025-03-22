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
@Table(name = "pca_logs")
public class PcaLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pca_change_log_id")
    Long PcaLogId;
    @Column(name="timestamp")
    LocalDateTime timestamp;
    @Column(name="log_type")
    LogType logType;
    @ManyToOne
    @JoinColumn(name="pca_id")
    Pca pca;
    @Column(name="resource_level")
    int resourceLevel;
    @ManyToOne
    @JoinColumn(name="old_spot_id")
    Spot oldSpot;
    @ManyToOne
    @JoinColumn(name="new_spot_id", nullable=true)
    Spot newSpot;
    @Column(name="notes")
    String note;
}
