package io.github.jperparas.resourcetrackerpwa.repositories.projections;

import io.github.jperparas.resourcetrackerpwa.entities.Spot;

import java.time.LocalDateTime;


public interface SpotTimestamp {
  Spot getSpot();
  LocalDateTime getTimestamp();

}
