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
@Table(name = "spots")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_id")
    private int id;
    @Column(name = "spot_name")
    private String name;
    @Column(name = "has_aircraft")
    private Boolean hasAircraft;
    @Column(name="created")
    private LocalDateTime createdAt;

    @Column(name="updated")
    private LocalDateTime updatedAt;

    //TODO add onCreate and onUpdate


}
