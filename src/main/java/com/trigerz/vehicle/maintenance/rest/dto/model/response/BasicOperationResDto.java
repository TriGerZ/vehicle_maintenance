package com.trigerz.vehicle.maintenance.rest.dto.model.response;

public record BasicOperationResDto(
        int id,
        String type,
        int periodicityMileage,
        int periodicityMonth
) {
}


