package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import io.github.jperparas.resourcetrackerpwa.exceptions.NotFoundException;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestamp;
import io.github.jperparas.resourcetrackerpwa.services.SpotService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SpotController {
    public static final String SPOT_PATH ="/api/v1/spots";
    public static final String SPOT_PATH_ID = SPOT_PATH + "/{id}";
    private final SpotService spotService;

    @GetMapping(SPOT_PATH)
    public ResponseEntity<List<SpotDTO>> listSpots() {
        return ResponseEntity.ok(spotService.listSpots());
    }
    @GetMapping(SPOT_PATH+"/time")
    public ResponseEntity<List<SpotTimestamp>> listSpotsWithTimeStamp(@RequestParam(name="sortBy", required = false)String sortBy) {
        if (sortBy != null&&sortBy.equals("lastVisited"))
            return ResponseEntity.ok(spotService.listByElapsedTime());

        return ResponseEntity.ok(spotService.listSpotTimestamps());
    }

    @GetMapping(SPOT_PATH_ID)
    public ResponseEntity<SpotDTO> getSpotById(@PathVariable("id") int id) {
        return spotService.getSpot(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
}
    @GetMapping(SPOT_PATH_ID+"/gpu-count")
    public ResponseEntity<Integer> getGpuCountBySpotId(@PathVariable("id") int id) {
        return spotService.getGpuCount(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
   }

    @GetMapping(SPOT_PATH_ID+"/last-visited")
    public ResponseEntity<LocalDateTime>getLastVisitedTimeById(@PathVariable("id") int id) {
        return spotService.getLastVisitedTime(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);

    }


}
