package com.trigerz.vehicle.maintenance.rest.dto.model.request;

import java.time.LocalDate;

public record OperationHistoryReqDto(
        String link,
        Long price,
        String comment,
        LocalDate date,
        Integer mileage,
        Integer operationId
) {
}
