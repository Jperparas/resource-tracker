package io.github.jperparas.resourcetrackerpwa.repositories;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SpotRepository extends JpaRepository<Spot, Integer> {
    @Query("SELECT s AS spot, COUNT(g) AS gpuCount FROM Spot s " +
            "LEFT JOIN Gpu g ON g.spot.id = s.id " +
            "GROUP BY s " +
            "ORDER BY gpuCount ASC")
    List<Spot> findAllByGpu();


    List<Spot> findAllByOrderByUpdatedAt();

    @Query("SELECT COUNT(g) FROM Gpu g WHERE g.spot.id=:id ")
    Optional<Integer> getGpuCountById(@Param("id") int id);


}
