package io.github.jperparas.resourcetrackerpwa.mappers;

import io.github.jperparas.resourcetrackerpwa.entities.Gpu;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GpuMapper {


    Gpu GpuDTOToGpu(GpuDTO gpuDTO);


    GpuDTO GpuToGpuDTO(Gpu gpu);
}
