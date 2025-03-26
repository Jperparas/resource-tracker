package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.exceptions.NotFoundException;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;
import io.github.jperparas.resourcetrackerpwa.models.LogType;
import io.github.jperparas.resourcetrackerpwa.services.GpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    @PatchMapping(GPU_PATH_ID)
    public ResponseEntity<GpuDTO>updateGpuByIdWithLog(
            @PathVariable("id") int gpuId,
            @RequestParam("action") LogType logType,
            @RequestBody GpuDTO gpuDTO){
        if (gpuService.patchGpuById(gpuId,gpuDTO).isEmpty()) throw new NotFoundException();




        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
