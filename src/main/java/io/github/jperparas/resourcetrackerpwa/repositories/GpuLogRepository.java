package io.github.jperparas.resourcetrackerpwa.repositories;

import io.github.jperparas.resourcetrackerpwa.entities.GpuLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GpuLogRepository extends JpaRepository<GpuLog, Long> {
}
