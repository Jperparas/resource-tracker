package io.github.jperparas.resourcetrackerpwa.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name ="spots")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="spot_id")
    int id;
    @Column(name="spot_name")
    String name;
    @Column(name="has_chocks")
    boolean hasChocks;

    @OneToMany(mappedBy = "spot")
    Set<Gpu> gpus;

    @OneToMany(mappedBy = "spot")
    Set<Pca> pcas;

}
