package com.trigerz.vehicle.maintenance.persistence.model;

import java.util.List;

public record OwnerModel(
        Integer id,
        String name,
        List<VehicleModel> vehicleModelList
) {
}
