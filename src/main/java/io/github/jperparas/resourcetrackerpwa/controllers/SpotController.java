package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.services.SpotService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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


}
