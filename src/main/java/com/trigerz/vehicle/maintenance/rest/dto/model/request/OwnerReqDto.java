package com.trigerz.vehicle.maintenance.rest.dto.model.request;

import java.util.List;

public record OwnerReqDto(
        String name,
        List<VehicleReqDto> vehicles
) {
}
