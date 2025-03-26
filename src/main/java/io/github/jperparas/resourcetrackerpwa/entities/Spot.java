package io.github.jperparas.resourcetrackerpwa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    @Column(name = "has_chocks")
    private Boolean hasChocks;


}
