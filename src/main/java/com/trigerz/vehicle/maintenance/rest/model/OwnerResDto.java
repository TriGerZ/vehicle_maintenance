package com.trigerz.vehicle.maintenance.rest.model;

import java.util.List;

public record OwnerResDto(Integer id, String name, List<VehicleBasicResDto> vehicles) {
}
