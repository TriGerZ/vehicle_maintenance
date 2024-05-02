package com.trigerz.vehicle.maintenance.rest.dto.model.response;

import java.util.List;

public record OwnerResDto(
        int id,
        String name,
        List<BasicVehicleResDto> vehicles
) {
}
