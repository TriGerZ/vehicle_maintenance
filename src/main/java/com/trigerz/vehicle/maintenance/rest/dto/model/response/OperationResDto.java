package com.trigerz.vehicle.maintenance.rest.dto.model.response;

import java.util.List;

public record OperationResDto(
        int id,
        String type,
        int periodicityMileage,
        int periodicityMonth,
        List<OperationHistoryResDto> histories,
        int vehicleId
) {
}
