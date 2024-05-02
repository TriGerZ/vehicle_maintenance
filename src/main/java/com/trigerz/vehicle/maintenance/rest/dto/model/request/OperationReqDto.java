package com.trigerz.vehicle.maintenance.rest.dto.model.request;

import java.util.List;

public record OperationReqDto(
        String type,
        Integer periodicityMileage,
        Integer periodicityMonth,
        List<OperationHistoryReqDto> histories,
        Integer vehicleId
) {
}
