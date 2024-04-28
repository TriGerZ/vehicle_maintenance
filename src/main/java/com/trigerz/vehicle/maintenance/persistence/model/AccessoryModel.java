package com.trigerz.vehicle.maintenance.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AccessoryModel(Integer id, String name, BigDecimal price, LocalDate purchaseDate, Integer vehicleId) {

}
