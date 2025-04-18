package io.github.jperparas.resourcetrackerpwa.mappers;

import io.github.jperparas.resourcetrackerpwa.entities.GpuLog;
import io.github.jperparas.resourcetrackerpwa.models.GpuLogDTO;
import org.mapstruct.Mapper;

@Mapper(uses = {GpuMapper.class, SpotMapper.class})
public interface GpuLogMapper {

    GpuLog GpuLogDTOtoGpuLog(GpuLogDTO gpuLogDTO);

    GpuLogDTO gpuLogtoGpuLogDTO(GpuLog gpuLog);
}
