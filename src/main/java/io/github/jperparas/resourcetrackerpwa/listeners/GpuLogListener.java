package io.github.jperparas.resourcetrackerpwa.listeners;

import io.github.jperparas.resourcetrackerpwa.entities.GpuLog;
import jakarta.persistence.PostPersist;
import java.time.LocalDateTime;


public class GpuLogListener {
    @PostPersist
    public void postPersist(GpuLog gpuLog) {
       updateSpotTimeStamps(gpuLog);
    }

    private void updateSpotTimeStamps(GpuLog gpuLog) {
        if (gpuLog.getOldSpot() !=null){
            gpuLog.getOldSpot().setUpdatedAt(LocalDateTime.now());
        }
        if (gpuLog.getNewSpot() !=null){
            gpuLog.getNewSpot().setUpdatedAt(LocalDateTime.now());
        }

    }



}
