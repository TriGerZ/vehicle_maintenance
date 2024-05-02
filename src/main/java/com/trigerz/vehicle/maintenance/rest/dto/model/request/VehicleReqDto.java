package com.trigerz.vehicle.maintenance.rest.dto.model.request;

import java.time.LocalDate;
import java.util.List;

public record VehicleReqDto(
        String brand,
        String model,
        LocalDate purchaseDate,
        Integer currentMileage,
        Long price,
        List<AccessoryReqDto> accessories,
        List<OperationReqDto> operations,
        Integer ownerId
) {
}
