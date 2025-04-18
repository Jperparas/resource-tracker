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
import java.util.List;
import java.util.stream.Collectors;

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
                .gpu(oldGpuState)
                .timestamp(LocalDateTime.now())
                .logType(logType)
                .oldSpot(oldGpuState.getSpot())
                .resourceLevel(oldGpuState.getResourceLevel())
                .defBlueLevel(oldGpuState.getDefBlueLevel())
                .note(notes)
                .build();
        if (logType == LogType.MOVEMENT)
            gpuRecord.setNewSpot(newGpuState.getSpot());
        if (newGpuState.getDefBlueLevel() != null)
            gpuRecord.setDefBlueLevel(newGpuState.getDefBlueLevel());
        if (newGpuState.getResourceLevel() != null)
            gpuRecord.setResourceLevel(newGpuState.getResourceLevel());

        return gpuLogMapper.gpuLogtoGpuLogDTO(gpuLogRepository
                .save(gpuLogMapper.GpuLogDTOtoGpuLog(gpuRecord)));
    }

    @Override
    public List<GpuLogDTO> listGpuLogs() {
        return gpuLogRepository.findAll().stream().map(gpuLogMapper::gpuLogtoGpuLogDTO).collect(Collectors.toList());
    }

    @Override
    public List<GpuLogDTO> listGpuLogs(Integer gpuId) {
        return gpuLogRepository.findAllByGpu(gpuId).stream().map(gpuLogMapper::gpuLogtoGpuLogDTO).collect(Collectors.toList());
    }

    @Override
    public List<GpuLogDTO> listGpuLogs(Integer gpuId, Integer days) {
        LocalDateTime timestamp = LocalDateTime.now().minusDays(days);
        return gpuLogRepository.findAllByGpuAndTimestampAfter(gpuId,timestamp).stream().map(gpuLogMapper::gpuLogtoGpuLogDTO).collect(Collectors.toList());
    }

    private LogType determineLogType(GpuDTO oldState, GpuDTO newState) {
        if (newState.getSpot() != null) return LogType.MOVEMENT;
        if (newState.getPowered() != null && newState.getPowered() != oldState.getPowered()) {
            return newState.getPowered() ? LogType.POWER_ON : LogType.POWER_OFF;
        } else return LogType.EQUIPMENT_CHECK;
    }


}
