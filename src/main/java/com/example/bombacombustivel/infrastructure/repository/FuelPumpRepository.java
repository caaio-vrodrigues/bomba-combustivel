package com.example.bombacombustivel.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bombacombustivel.infrastructure.entity.FuelPump;

@Repository
public interface FuelPumpRepository extends JpaRepository<FuelPump, Integer> {}
