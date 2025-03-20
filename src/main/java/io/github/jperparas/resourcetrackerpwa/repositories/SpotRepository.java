package io.github.jperparas.resourcetrackerpwa.repositories;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
