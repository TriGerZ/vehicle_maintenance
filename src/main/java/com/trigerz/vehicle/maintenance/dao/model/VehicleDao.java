package com.trigerz.vehicle.maintenance.dao.model;

import java.util.List;

public record VehicleDao(
        Integer id, String name, Integer currentKilometers, List<OperationHistoryDao> operationHistoryDaoList
) {
}
