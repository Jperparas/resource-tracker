package io.github.jperparas.resourcetrackerpwa.repositories.projections;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.jperparas.resourcetrackerpwa.models.SpotDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SpotTimestampDTO {
    @JsonProperty("spot")
    private SpotDTO spotDTO;
    private LocalDateTime timestamp;
}
