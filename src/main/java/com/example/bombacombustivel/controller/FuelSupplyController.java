package com.example.bombacombustivel.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bombacombustivel.infrastructure.entity.FuelSupply;
import com.example.bombacombustivel.service.FuelSupplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fuel-supply")
@RequiredArgsConstructor
public class FuelSupplyController {
	
	private final FuelSupplyService service;

	@PostMapping
	public ResponseEntity<FuelSupply> newFuelSupply(
		@RequestParam Integer idPump,
		@RequestParam BigDecimal totalLiters
	){
		return ResponseEntity.ok(service.createFuelSupply(idPump, totalLiters));
	}
	
	@GetMapping
	public ResponseEntity<List<FuelSupply>> listAllSupplys(){
		return ResponseEntity.ok(service.getAllFuelSupply());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuelSupply> searchSupply(@PathVariable Integer id){
		return ResponseEntity.ok(service.getFuelSupplyById(id));
	}
}
