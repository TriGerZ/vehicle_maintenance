package com.trigerz.vehicle.maintenance.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public final class AccessoryModel {
    private Integer id;
    private String name;
    private BigDecimal price;
    private LocalDate purchaseDate;
    private Integer vehicleId;
}
