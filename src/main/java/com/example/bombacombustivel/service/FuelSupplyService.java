package com.example.bombacombustivel.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.bombacombustivel.infrastructure.entity.FuelPump;
import com.example.bombacombustivel.infrastructure.entity.FuelSupply;
import com.example.bombacombustivel.infrastructure.entity.TypeOfFuel;
import com.example.bombacombustivel.infrastructure.repository.FuelSupplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuelSupplyService {
	
	private final FuelSupplyRepository repo;
	private final FuelPumpService pumpService;
	private final TypeOfFuelService fuelService;
	
	public FuelSupply createFuelSupply(Integer idPump, BigDecimal totalLiters) {
		FuelPump pump = pumpService.getFuelPumpById(idPump);
		TypeOfFuel fuel = fuelService.getTypeOfFuelById(pump.getFuel().getId());
		FuelSupply supply = FuelSupply.builder()
			.timeStamp(LocalDateTime.now())
			.literPrice(fuel.getLiterPrice())
			.pump(idPump)
			.totalLiters(totalLiters)
			.totalPayment(totalLiters.multiply(fuel.getLiterPrice()))
			.typeOfFuel(fuel.getName())
			.build();
		return repo.saveAndFlush(supply);
	}
	
	public List<FuelSupply> getAllFuelSupply(){
		return repo.findAll();
	}
	
	public FuelSupply getFuelSupplyById(Integer id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Uncapable to find ressource with id: "+id));
	}
}
