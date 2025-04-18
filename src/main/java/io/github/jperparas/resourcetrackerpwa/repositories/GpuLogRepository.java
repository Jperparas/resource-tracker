package io.github.jperparas.resourcetrackerpwa.repositories;

import io.github.jperparas.resourcetrackerpwa.entities.GpuLog;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface GpuLogRepository extends JpaRepository<GpuLog, Long> {
    @EntityGraph(attributePaths = {"gpu", "oldSpot", "newSpot"})
    @Query("SELECT gl  FROM GpuLog gl " +
            "WHERE gl.gpu.id =:id " +
            "ORDER BY gl.timestamp DESC"
    )
    List<GpuLog> findAllByGpu(@Param("id") Integer id);

    @EntityGraph(attributePaths = {"gpu", "oldSpot", "newSpot"})
    @Query("SELECT gl  FROM GpuLog gl " +
            "WHERE gl.gpu.id =:id AND gl.timestamp > :timestamp " +
            "ORDER BY gl.timestamp DESC"
    )
    List<GpuLog> findAllByGpuAndTimestampAfter(@Param("id") Integer id, @Param("timestamp") LocalDateTime timestamp);


}


