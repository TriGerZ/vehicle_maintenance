package com.trigerz.vehicle.maintenance.rest.dto.model.response;

import java.time.LocalDate;

public record OperationHistoryResDto(
        int id,
        String link,
        long price,
        String comment,
        LocalDate date,
        int mileage,
        int operationId
) {
}
