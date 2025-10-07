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

import com.example.bombacombustivel.infrastructure.entity.TypeOfFuel;
import com.example.bombacombustivel.service.TypeOfFuelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/fuel-type")
@RequiredArgsConstructor
public class TypeOfFuelController {
	
	private final TypeOfFuelService service;
	
	@PostMapping
	public ResponseEntity<TypeOfFuel> newTypeOfFuel(
		@RequestBody TypeOfFuel body
	){
		return ResponseEntity.ok(service.createTypeOfFuel(body));
	}
	
	@GetMapping
	public ResponseEntity<List<TypeOfFuel>> listTypesOfFuel(){
		return ResponseEntity.ok(service.getAllTypesOfFuel());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TypeOfFuel> searchTypeOfFuelById(
		@PathVariable Integer id
	){
		return ResponseEntity.ok(service.getTypeOfFuelById(id));
	}
	
	@PutMapping
	public ResponseEntity<TypeOfFuel> editTypeOfFuel(
		@RequestParam Integer id, 
		@RequestBody TypeOfFuel body
	){
		return ResponseEntity.ok(service.updateTypeOfFuel(id, body));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excludeTypeOfFuelById(
		@PathVariable Integer id
	){
		return ResponseEntity.ok(service.deleteTypeOfFuel(id));
	}
}
