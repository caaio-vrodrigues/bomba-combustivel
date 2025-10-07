package com.example.bombacombustivel.service;

import org.springframework.stereotype.Service;

import com.example.bombacombustivel.infrastructure.entity.TypeOfFuel;
import com.example.bombacombustivel.infrastructure.repository.TypeOfFuelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeOfFuelService {
	
	private final TypeOfFuelRepository repo;
	
	public TypeOfFuel createTypeOfFuel(TypeOfFuel body) {
		return repo.saveAndFlush(body);
	}
}
