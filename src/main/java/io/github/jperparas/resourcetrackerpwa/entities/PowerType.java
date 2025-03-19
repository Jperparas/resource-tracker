package io.github.jperparas.resourcetrackerpwa.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "power_types")
public class PowerType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="power_type_id")
    int powerTypeId;

    @Column(name ="name")
    String name;
}
