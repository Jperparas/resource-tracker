package io.github.jperparas.resourcetrackerpwa.controllers;

import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.services.GpuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GpuController {
    public static final String GPU_PATH = "/api/v1/gpus";
    public static final String GPU_PATH_ID = GPU_PATH+"/{id}";

    private final GpuService gpuService;

    @GetMapping(GPU_PATH)
    public ResponseEntity<List<GpuDTO>>listGpus() {
        return ResponseEntity.ok(gpuService.listGpus());
    }




}
