package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.exceptions.NotFoundException;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuUpdateRequest;
import io.github.jperparas.resourcetrackerpwa.services.GpuLogService;
import io.github.jperparas.resourcetrackerpwa.services.GpuService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GpuController {
    public static final String GPU_PATH = "/api/v1/gpus";
    public static final String GPU_PATH_ID = GPU_PATH + "/{id}";

    private final GpuService gpuService;
    private final GpuLogService gpuLogService;

    @GetMapping(GPU_PATH)
    public ResponseEntity<List<GpuDTO>> listGpus() {
        return ResponseEntity.ok(gpuService.listGpus());
    }

    @Transactional
    @PatchMapping(GPU_PATH_ID)
    public ResponseEntity<GpuDTO> updateGpuById(@PathVariable("id") int id,
                                                @RequestBody GpuUpdateRequest updateRequest) {
        GpuDTO gpuDTO = updateRequest.getGpuDTO();
        GpuDTO updatedGpu = gpuService.patchGpuById(id, gpuDTO)
                .orElseThrow(NotFoundException::new);
        gpuLogService.recordGpuLogById(id, gpuDTO, updateRequest.getNote());
        return ResponseEntity.ok(updatedGpu);
    }

}
