package com.example.bombacombustivel.infrastructure.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Table(name = "fuel_supply")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FuelSupply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "time_stamp")
	private LocalDateTime timeStamp;
	
	@Column(name = "pump_id")
	private Integer pump;
	
	@Column(name = "fuel")
	private String typeOfFuel;
	
	@Column(name = "total_liters")
	private BigDecimal totalLiters;
	
	@Column(name = "liter_price")
	private BigDecimal literPrice;
	
	@Column(name = "total_payment")
	private BigDecimal totalPayment;
}
