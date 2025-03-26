package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.mappers.GpuLogMapper;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;
import io.github.jperparas.resourcetrackerpwa.models.LogType;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.GpuLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GpuLogServiceImpl implements GpuLogService {
 private final GpuLogRepository gpuLogRepository;
 private final GpuLogMapper gpuLogMapper;
 private final GpuService gpuService;

    @Override
    public GpuLogDTO recordGpuLog(GpuLogDTO gpuLogDTO) {
        return gpuLogMapper.GpuLogtoGpuLogDTO(gpuLogRepository
                .save(gpuLogMapper.GpuLogDTOtoGpuLog(gpuLogDTO)));
    }
//TODO:
//    @Override
//    public GpuLogDTO recordGpuLog(GpuDTO gpuDTO, LogType logType, SpotDTO newSpot, String note) {
//
////        Optional<GpuDTO> foundGpu = gpuService.getGpu(gpuId);
////
////        GpuLogDTO.GpuLogDTOBuilder logBuilder = GpuLogDTO.builder()
////                .timestamp(LocalDateTime.now())
////                .logType(logType)
////                .gpuDto(gpuDTO)
////                .resourceLevel(gpuDTO.getResourceLevel())
////                .defBlueLevel(gpuDTO.getDefBlueLevel())
////                .oldSpotDto(gpuDTO.getSpot())
////                .note()
////        return null;
////    }
}
