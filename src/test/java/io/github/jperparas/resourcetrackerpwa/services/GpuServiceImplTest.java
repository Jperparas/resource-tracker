package io.github.jperparas.resourcetrackerpwa.services;

import io.github.jperparas.resourcetrackerpwa.entities.Gpu;
import io.github.jperparas.resourcetrackerpwa.mappers.GpuMapper;
import io.github.jperparas.resourcetrackerpwa.mappers.PowerTypeMapper;
import io.github.jperparas.resourcetrackerpwa.mappers.SpotMapper;
import io.github.jperparas.resourcetrackerpwa.models.GpuDTO;
import io.github.jperparas.resourcetrackerpwa.repositories.GpuRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GpuServiceImplTest {

    @Mock
    private GpuRepository gpuRepository;

    @Mock
    private GpuMapper gpuMapper;

    @Mock
    private SpotMapper spotMapper;

    @Mock
    private PowerTypeMapper powerTypeMapper;

    @InjectMocks
    private GpuServiceImpl gpuService;

    @Rollback
    @Test
    void listGpusShouldReturnAllGpus() {
        // Given
        List<Gpu> gpus = Arrays.asList(
                createSampleGpu(1),
                createSampleGpu(2)
        );
        List<GpuDTO> gpuDTOs = Arrays.asList(
                createSampleGpuDTO(1),
                createSampleGpuDTO(2)
        );

        when(gpuRepository.findAll()).thenReturn(gpus);
        when(gpuMapper.gpuToGpuDTO(gpus.get(0))).thenReturn(gpuDTOs.get(0));
        when(gpuMapper.gpuToGpuDTO(gpus.get(1))).thenReturn(gpuDTOs.get(1));

        // When
        List<GpuDTO> result = gpuService.listGpus();

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyElementsOf(gpuDTOs);
        verify(gpuRepository).findAll();
    }



    @Test
    void saveNewGpu() {
    }

    @Test
    void deleteGpu() {
    }

    @Test
    void getGpu() {
    }

    @Test
    void updateGpuById() {
    }

    @Test
    void patchGpuById() {
    }

    private Gpu createSampleGpu(int id) {
        Gpu gpu = new Gpu();
        gpu.setId(id);
        gpu.setGpuNumber("GPU-" + id);
        gpu.setPowered(true);
        gpu.setResourceLevel((byte) 80);
        // Set other properties
        return gpu;
    }

    private GpuDTO createSampleGpuDTO(int id) {
        return GpuDTO.builder()
                .id(id)
                .gpuNumber("GPU-" + id)
                .powered(true)
                .resourceLevel((byte) 80)
                .build();
    }

}