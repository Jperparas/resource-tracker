package io.github.jperparas.resourcetrackerpwa.entities;

import jakarta.persistence.*;

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
}
