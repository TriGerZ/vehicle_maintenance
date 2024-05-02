package com.trigerz.vehicle.maintenance.rest.dto.model.response;

import java.time.LocalDate;

public record BasicVehicleResDto(
        int id,
        String name,
        int currentMileage,
        boolean obsoleteMileage,
        boolean obsoleteOperations,
        LocalDate lastMileageUpdate
) {
}
