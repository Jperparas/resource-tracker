package io.github.jperparas.resourcetrackerpwa.repositories;

import io.github.jperparas.resourcetrackerpwa.entities.Gpu;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.lang.NonNull;


import java.util.List;

public interface GpuRepository extends JpaRepository<Gpu, Integer> {


    @EntityGraph(attributePaths = "spot")
    @Override
    @NonNull
    List<Gpu> findAll();

}
