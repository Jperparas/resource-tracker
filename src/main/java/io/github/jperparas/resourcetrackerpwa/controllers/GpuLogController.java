package io.github.jperparas.resourcetrackerpwa.controllers;



import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;
import io.github.jperparas.resourcetrackerpwa.services.GpuLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GpuLogController {
    public static final String GPU_LOG_PATH = "/api/v1/gpu-logs";
    public static final String GPU_LOG_PATH_ID = GPU_LOG_PATH+"/gpu/{id}";

    private final GpuLogService gpuLogService;

    @GetMapping(GPU_LOG_PATH)
    public ResponseEntity<List<GpuLogDTO>> getAllGpulogs(){

        return ResponseEntity.ok(gpuLogService.listGpuLogs());
    }

    @GetMapping(GPU_LOG_PATH_ID)
    public ResponseEntity<List<GpuLogDTO>> getGpulogs(@PathVariable Integer id,
                                                      @RequestParam(name="days", required=false) Integer days){
        if (days != null){
            return ResponseEntity.ok(gpuLogService.listGpuLogs(id, days));
        }
        return ResponseEntity.ok(gpuLogService.listGpuLogs(id));
    }
}
