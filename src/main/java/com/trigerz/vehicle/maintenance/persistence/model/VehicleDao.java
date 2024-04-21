package com.trigerz.vehicle.maintenance.persistence.model;

import java.util.List;

public record VehicleDao(
        Integer id, String name, Integer currentKilometers, List<OperationDao> operationDaoList
) {
    public VehicleDao(String name, Integer currentKilometers) {
        this(null, name, currentKilometers, null);
    }
}
