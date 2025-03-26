package io.github.jperparas.resourcetrackerpwa.repositories.projections;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface SpotTimestamp {
    Spot getSpot();
    LocalDateTime getTimestamp();
}
