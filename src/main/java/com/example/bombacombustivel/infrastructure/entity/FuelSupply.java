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
@Table(name="fuel_supply")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FuelSupply {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="time_stamp", nullable=false)
	private LocalDateTime timeStamp;
	
	@Column(name="pump_id", nullable=false)
	private Integer pump;
	
	@Column(name="fuel", nullable=false)
	private String typeOfFuel;
	
	@Column(name="total_liters", nullable=false)
	private BigDecimal totalLiters;
	
	@Column(name="liter_price", nullable=false)
	private BigDecimal literPrice;
	
	@Column(name="total_payment", nullable=false)
	private BigDecimal totalPayment;
}
