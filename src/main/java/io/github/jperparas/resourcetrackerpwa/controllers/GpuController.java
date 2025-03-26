package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.exceptions.NotFoundException;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.services.GpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GpuController {
    public static final String GPU_PATH = "/api/v1/gpus";
    public static final String GPU_PATH_ID = GPU_PATH + "/{id}";

    private final GpuService gpuService;

    @GetMapping(GPU_PATH)
    public ResponseEntity<List<GpuDTO>> listGpus() {
        return ResponseEntity.ok(gpuService.listGpus());
    }

    @PatchMapping(GPU_PATH_ID)
    public ResponseEntity<GpuDTO> updateGpuById(@PathVariable("id") int id, @RequestBody GpuDTO gpuDTO) {
        if (gpuService.patchGpuById(id, gpuDTO).isEmpty()) throw new NotFoundException();


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
