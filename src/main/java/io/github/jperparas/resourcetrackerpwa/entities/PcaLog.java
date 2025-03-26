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
    @Column(name = "pca_change_log_id")
    private Long pcaLogId;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    @Column(name = "log_type")
    private LogType logType;
    @ManyToOne
    @JoinColumn(name = "pca_id")
    private Pca pca;
    @Column(name = "resource_level")
    private Byte resourceLevel;
    @ManyToOne
    @JoinColumn(name = "old_spot_id")
    private Spot oldSpot;
    @ManyToOne
    @JoinColumn(name = "new_spot_id", nullable = true)
    private Spot newSpot;
    @Column(name = "notes")
    private String note;
}
