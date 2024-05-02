package com.trigerz.vehicle.maintenance.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public final class OperationHistoryModel {
    private Integer id;
    private String link;
    private BigDecimal price;
    private String comment;
    private LocalDate date;
    private Integer mileage;
    private Integer operationId;
}
