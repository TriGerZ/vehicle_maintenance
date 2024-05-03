package com.trigerz.vehicle.maintenance.rest.dto.model.response;

import java.time.LocalDate;

public record AccessoryResDto(
        int id,
        String name,
        long price,
        LocalDate purchaseDate,
        int vehicleId
) {
}
