package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.projections.SpotTimestamp;
import io.github.jperparas.resourcetrackerpwa.services.SpotService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SpotController {
    public static final String SPOT_PATH ="/api/v1/spot";
    public static final String SPOT_PATH_ID = SPOT_PATH + "/{id}";
    private final SpotService spotService;

    @GetMapping(SPOT_PATH)
    public List<SpotDTO> listSpots() {
        return spotService.listSpots();
    }
    @GetMapping(SPOT_PATH_ID)
    public ResponseEntity<SpotDTO> getSpotById(@PathVariable("id") int id) {
        return spotService.getSpot(id).map(ResponseEntity::ok).orElseThrow(
                ()-> new EntityNotFoundException("Requested spot no longer exists"));
}
    @GetMapping(SPOT_PATH+"/time")
    public List<SpotTimestamp> listSpotsByElapsedTime() {
        return spotService.listByElapsedTime();
    }
    @GetMapping(SPOT_PATH +"/time/{id}")
    public ResponseEntity<LocalDateTime>getLastVisitedTimeById(@PathVariable("id") int id) {
        return spotService.getLastVisitedTime(id).map(ResponseEntity::ok).orElseThrow(
                ()->new EntityNotFoundException("Requested spot no longer exists"));

    }


}
