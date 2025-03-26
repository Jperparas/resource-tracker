package io.github.jperparas.resourcetrackerpwa.mappers;

import io.github.jperparas.resourcetrackerpwa.entities.PcaLog;
import io.github.jperparas.resourcetrackerpwa.models.PcaLogDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PcaLogMapper {
    PcaLog PcalogDTOToPcaLog(PcaLogDTO pcaLogDTO);

    PcaLogDTO pcaLogToPcaLogDTO(PcaLog pcaLog);
}
