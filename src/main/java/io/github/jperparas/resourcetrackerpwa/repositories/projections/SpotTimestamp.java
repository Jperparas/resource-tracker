package io.github.jperparas.resourcetrackerpwa.repositories.projections;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface SpotTimestamp {
    String getName();
    Integer getId();
    LocalDateTime getTimestamp();
}
