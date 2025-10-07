package com.example.bombacombustivel.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bombacombustivel.infrastructure.entity.FuelSupply;

@Repository
public interface FuelSupplyRepository extends JpaRepository<FuelSupply, Integer> {}
