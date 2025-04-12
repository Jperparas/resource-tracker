package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.exceptions.NotFoundException;
import io.github.jperparas.resourcetrackerpwa.mappers.GpuLogMapper;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;
import io.github.jperparas.resourcetrackerpwa.models.LogType;
import io.github.jperparas.resourcetrackerpwa.repositories.GpuLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GpuLogServiceImpl implements GpuLogService {
    private final GpuLogRepository gpuLogRepository;
    private final GpuLogMapper gpuLogMapper;
    private final GpuService gpuService;

    @Override
    public GpuLogDTO recordGpuLogById(int gpuId, GpuDTO newGpuState, String notes) {
        GpuDTO oldGpuState = gpuService.getGpu(gpuId)
                .orElseThrow(NotFoundException::new);

        var logType = determineLogType(oldGpuState, newGpuState);
        GpuLogDTO gpuRecord = GpuLogDTO.builder()
                .gpuDto(oldGpuState)
                .timestamp(LocalDateTime.now())
                .logType(logType)
                .oldSpotDto(oldGpuState.getSpot())
                .resourceLevel(oldGpuState.getResourceLevel())
                .defBlueLevel(oldGpuState.getDefBlueLevel())
                .note(notes)
                .build();
        if (logType == LogType.MOVEMENT)
            gpuRecord.setNewSpotDto(newGpuState.getSpot());
        if (newGpuState.getDefBlueLevel() != null)
            gpuRecord.setDefBlueLevel(newGpuState.getDefBlueLevel());
        if (newGpuState.getResourceLevel() != null)
            gpuRecord.setResourceLevel(newGpuState.getResourceLevel());

        return gpuLogMapper.GpuLogtoGpuLogDTO(gpuLogRepository
                .save(gpuLogMapper.GpuLogDTOtoGpuLog(gpuRecord)));
    }

    private LogType determineLogType(GpuDTO oldState, GpuDTO newState) {
        if (newState.getSpot() != null) return LogType.MOVEMENT;
        if (newState.getPowered() != null && newState.getPowered() != oldState.getPowered()) {
            return newState.getPowered() ? LogType.POWER_ON : LogType.POWER_OFF;
        } else return LogType.EQUIPMENT_CHECK;
    }


}
