package com.trigerz.vehicle.maintenance.rest.model;

import com.trigerz.vehicle.maintenance.persistence.model.OperationModel;

import java.util.List;

public record VehicleDto(Integer id, String name, List<OperationModel> operationToPerformed) {
}
