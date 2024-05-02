package com.trigerz.vehicle.maintenance.rest.dto.model.request;

import java.time.LocalDate;

public record AccessoryReqDto(
        String name,
        Long price,
        LocalDate purchaseDate,
        Integer vehicleId
) {
}
