package io.github.jperparas.resourcetrackerpwa.repositories;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
//TODO remove timestamp related queries
public interface SpotRepository extends JpaRepository<Spot, Integer> {
    @Query("SELECT s AS spot, COUNT(g) AS gpuCount FROM Spot s " +
            "LEFT JOIN Gpu g ON g.spot.id = s.id " +
            "GROUP BY s " +
            "ORDER BY gpuCount ASC")
    List<Spot> findAllByGpu();

    @Query("SELECT s FROM Spot s " +
            "JOIN Gpu g ON g.spot.id=s.id " +
            "JOIN g.gpuLogs gl " +
            "GROUP BY s.id " +
            "ORDER BY MAX(gl.timestamp)"
    )
    List<Spot> findAllByLastVisited();


    @Query("SELECT s AS spot, MAX(gl.timestamp) AS timestamp FROM Spot s " +
            "LEFT JOIN Gpu g ON g.spot.id=s.id " +
            "LEFT JOIN GpuLog gl ON gl.gpu.id=g.id " +
            "GROUP BY s "
    )
    List<SpotTimestamp> findAllWithTimestamp();

    @Query("SELECT s AS spot, MAX(gl.timestamp) AS timestamp FROM Spot s " +
            "LEFT JOIN Gpu g ON g.spot.id=s.id " +
            "LEFT JOIN GpuLog gl ON gl.gpu.id=g.id " +
            "GROUP BY s " +
            "ORDER BY timestamp"
    )
    List<SpotTimestamp> findAllSpotsSortedByTimestamp();

    @Query("SELECT MAX(gl.timestamp) From Spot s " +
            "JOIN Gpu g ON g.spot.id=s.id " +
            "JOIN g.gpuLogs gl " +
            "WHERE s.id = :spotId "
    )
    Optional<LocalDateTime> findLastVisitedById(@Param("spotId") int spotID);

    @Query("SELECT COUNT(g) FROM Gpu g WHERE g.spot.id=:id ")
    Optional<Integer> getGpuCountById(@Param("id") int id);


}
