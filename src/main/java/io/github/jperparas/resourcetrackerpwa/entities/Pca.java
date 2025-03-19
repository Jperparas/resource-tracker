package io.github.jperparas.resourcetrackerpwa.entities;

import jakarta.persistence.*;
@Entity
@Table(name="pcas")
public class Pca {
    @Id
    @Column(name = "pca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name="spot_id")
    Spot spot;

    @Column(name="pca_serial_number")
    String pcaNumber;

    @ManyToOne
    @JoinColumn(name="power_type_id")
    PowerType powerType;

    @Column(name="resource_level")
    byte resource_level;
}
