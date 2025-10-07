package com.example.bombacombustivel.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<TypeOfFuel> newTypeOfFuel(@RequestBody TypeOfFuel body){
		return ResponseEntity.ok(service.createTypeOfFuel(body));
	}
}
