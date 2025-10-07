package com.example.bombacombustivel.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fuel_pump")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FuelPump {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="type_fuel", nullable=false)
	private TypeOfFuel fuel;
}
