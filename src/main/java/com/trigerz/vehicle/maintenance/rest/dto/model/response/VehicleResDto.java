package com.trigerz.vehicle.maintenance.rest.dto.model.response;

import java.util.List;

public record VehicleResDto(
        int id,
        String name,
        int currentMileage,
        List<OperationResDto> operations,
        List<OperationResDto> operationsToPerformed,
        boolean obsoleteMileage,
        boolean obsoleteOperations
) {
}
