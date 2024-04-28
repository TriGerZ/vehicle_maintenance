package com.trigerz.vehicle.maintenance.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record OperationHistoryModel(
        Integer id,
        String link,
        BigDecimal price,
        String comment,
        Integer operationId,
        LocalDate date,
        Integer mileage
) {
}
