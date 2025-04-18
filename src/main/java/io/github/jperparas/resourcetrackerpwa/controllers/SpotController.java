package io.github.jperparas.resourcetrackerpwa.controllers;


import io.github.jperparas.resourcetrackerpwa.exceptions.NotFoundException;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.services.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class SpotController {
    public static final String SPOT_PATH = "/api/v1/spots";
    public static final String SPOT_PATH_ID = SPOT_PATH + "/{id}";
    private final SpotService spotService;

    @GetMapping(SPOT_PATH)
    public ResponseEntity<List<SpotDTO>> listSpots(@RequestParam(name = "sortBy", required = false) String sortBy) {
        if (sortBy != null && sortBy.equals("gpu"))
            return ResponseEntity.ok(spotService.listSpotsByGpuCount());
        if (sortBy != null && sortBy.equals("lastVisited"))
            return ResponseEntity.ok(spotService.listByLastUpdate());
        return ResponseEntity.ok(spotService.listSpots());
    }

    @GetMapping(SPOT_PATH_ID)
    public ResponseEntity<SpotDTO> getSpotById(@PathVariable("id") int id) {
        return spotService.getSpot(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
    }

    @GetMapping(SPOT_PATH_ID + "/gpu-count")
    public ResponseEntity<Integer> getGpuCountBySpotId(@PathVariable("id") int id) {
        return spotService.getGpuCount(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
    }
    @PutMapping(SPOT_PATH_ID)
    public ResponseEntity<SpotDTO> updateSpotById(@PathVariable("id")Integer id, @RequestBody SpotDTO spot) {
        SpotDTO updatedSpot = spotService.updateSpotById(id,spot).orElseThrow(NotFoundException::new);

        return ResponseEntity.ok(updatedSpot);

    }

    @PatchMapping(SPOT_PATH_ID)
    public ResponseEntity<SpotDTO> patchSpotById(@PathVariable("id") int id, @RequestBody SpotDTO spot) {
        SpotDTO updatedSpot = spotService.patchSpotById(id,spot).orElseThrow(NotFoundException::new);

        return ResponseEntity.ok(updatedSpot);
    }

    @DeleteMapping(SPOT_PATH_ID)
    public ResponseEntity<Void> deleteSpotById(@PathVariable("id") int id) {
        if (!spotService.deleteSpotById(id)){
            throw new NotFoundException();
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(SPOT_PATH)
    public ResponseEntity<Void> createSpot(@RequestBody SpotDTO spotDTO) {
        SpotDTO savedSpot = spotService.saveNewSpot(spotDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, SPOT_PATH + "/" + savedSpot.getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }




}
