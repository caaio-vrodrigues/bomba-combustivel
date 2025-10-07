package com.example.bombacombustivel.infrastructure.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="fuel_type")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TypeOfFuel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable=false, unique=true)
	private String name;
	
	@Column(name="liter_price", nullable=false)
	private BigDecimal literPrice;
}
