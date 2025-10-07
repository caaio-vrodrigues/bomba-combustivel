package com.example.bombacombustivel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bombacombustivel.infrastructure.entity.FuelPump;
import com.example.bombacombustivel.service.FuelPumpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fuel-pump")
@RequiredArgsConstructor
public class FuelPumpController {
	
	private final FuelPumpService service;
	
	@PostMapping
	public ResponseEntity<FuelPump> createFuelPump(
		@RequestBody FuelPump body
	){
		return ResponseEntity.ok(service.createFuelPump(body));
	}
	
	@GetMapping
	public ResponseEntity<List<FuelPump>> listFuelPumps(){
		return ResponseEntity.ok(service.getAllFuelPumps());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuelPump> searchFuelPumpById(
		@PathVariable Integer id
	){
		return ResponseEntity.ok(service.getFuelPumpById(id));
	}
	
	@PutMapping
	public ResponseEntity<FuelPump> editFuelPumpById(
		@RequestParam Integer idPump,
		@RequestParam Integer idTypeOfFuel
	){
		return ResponseEntity.ok(service
			.updateFuelPumpById(idPump, idTypeOfFuel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excludeFuelPump(@PathVariable Integer id){
		return ResponseEntity.ok(service.deleteFuelPump(id));
	}
}
