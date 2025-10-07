package com.example.bombacombustivel.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bombacombustivel.infrastructure.entity.TypeOfFuel;

@Repository
public interface TypeOfFuelRepository extends JpaRepository<TypeOfFuel, Integer> {}
