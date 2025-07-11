package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.exceptions.NotFoundException;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuUpdateRequest;
import io.github.jperparas.resourcetrackerpwa.services.GpuLogService;
import io.github.jperparas.resourcetrackerpwa.services.GpuService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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
    private final GpuLogService gpuLogService;

    @GetMapping(GPU_PATH)
    public ResponseEntity<List<GpuDTO>> listGpus() {
        return ResponseEntity.ok(gpuService.listGpus());
    }

    @GetMapping(GPU_PATH_ID)
    public ResponseEntity<GpuDTO> getGpuById(@PathVariable int id) {
        return gpuService.getGpu(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
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

    @DeleteMapping(GPU_PATH_ID)
    public ResponseEntity<Void> deleteGpuById(@PathVariable("id") int id) {
        if (!gpuService.deleteGpu(id)) throw new NotFoundException();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(GPU_PATH)
    public ResponseEntity<Void> addGpu(@RequestBody GpuDTO gpuDTO) {
        GpuDTO savedGpu = gpuService.saveNewGpu(gpuDTO);
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.LOCATION, GPU_PATH_ID + "/" + savedGpu.getId());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
