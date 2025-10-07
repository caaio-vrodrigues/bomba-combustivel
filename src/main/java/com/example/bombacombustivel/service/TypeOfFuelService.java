package com.example.bombacombustivel.service;

import java.util.List;

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
	
	public List<TypeOfFuel> getAllTypesOfFuel(){
		return repo.findAll();
	}
	
	public TypeOfFuel getTypeOfFuelById(Integer id) {
		return repo.findById(id).orElseThrow(()->
			new NullPointerException("Uncapable to find ressource with id: "+id));
	}
	
	public TypeOfFuel updateTypeOfFuel(Integer id, TypeOfFuel body) {
		TypeOfFuel fuel = getTypeOfFuelById(id);
		body.setId(id);
		body.setName(body.getName() != null ? 
			body.getName() : fuel.getName());
		body.setLiterPrice(body.getLiterPrice() != null ? 
			body.getLiterPrice() : fuel.getLiterPrice());
		return repo.saveAndFlush(body);
	}
	
	public boolean deleteTypeOfFuel(Integer id) {
		if(!repo.existsById(id)) throw 
			new NullPointerException("Uncapable to find ressource with id: "+id);
		repo.deleteById(id);
		return !repo.existsById(id);
	}
}
