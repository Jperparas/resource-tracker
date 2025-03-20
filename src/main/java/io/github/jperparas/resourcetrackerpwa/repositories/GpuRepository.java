package io.github.jperparas.resourcetrackerpwa.repositories;

import io.github.jperparas.resourcetrackerpwa.entities.Gpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GpuRepository extends JpaRepository<Gpu, Long> {
}
