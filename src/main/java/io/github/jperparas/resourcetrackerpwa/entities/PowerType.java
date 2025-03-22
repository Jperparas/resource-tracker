package io.github.jperparas.resourcetrackerpwa.entities;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "power_types")
public class PowerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="power_type_id")
    private int powerTypeId;

    @Column(name ="name")
    private String name;
}
