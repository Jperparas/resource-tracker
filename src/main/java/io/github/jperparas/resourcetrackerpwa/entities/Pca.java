package io.github.jperparas.resourcetrackerpwa.entities;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="pcas")
public class Pca {
    @Id
    @Column(name = "pca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    @ManyToOne
    @JoinColumn(name="spot_id")
    private Spot spot;

    @Column(name="pca_serial_number")
    private String pcaNumber;

    @ManyToOne
    @JoinColumn(name="power_type_id")
    private PowerType powerType;

    @Column(name="resource_level")
    private Byte resourceLevel;
}
