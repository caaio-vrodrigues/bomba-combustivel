package com.example.bombacombustivel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bombacombustivel.infrastructure.entity.FuelPump;
import com.example.bombacombustivel.infrastructure.entity.TypeOfFuel;
import com.example.bombacombustivel.infrastructure.repository.FuelPumpRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuelPumpService {
	
	private final FuelPumpRepository repo;
	private final TypeOfFuelService typeOfFuelService;
	
	public FuelPump createFuelPump(FuelPump body) {
		TypeOfFuel fuel = typeOfFuelService
			.getTypeOfFuelById(body.getFuel().getId());
		body.setFuel(fuel);
		return repo.saveAndFlush(body);
	}
	
	public List<FuelPump> getAllFuelPumps() {
		return repo.findAll();
	}
	
	public FuelPump getFuelPumpById(Integer id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Uncapable to find ressource with id: "+id));
	}
	
	public FuelPump updateFuelPumpById(Integer idPump, Integer idTypeOfFuel) {
		TypeOfFuel fuel = typeOfFuelService.getTypeOfFuelById(idTypeOfFuel);
		FuelPump pump = getFuelPumpById(idPump);
		pump.setFuel(fuel);
		return repo.saveAndFlush(pump);
	}
	
	public boolean deleteFuelPump(Integer id) {
		if(!repo.existsById(id)) throw 
			new NullPointerException("Uncapable to find ressource with id: "+id);
		repo.deleteById(id);
		return !repo.existsById(id);
	}
}
