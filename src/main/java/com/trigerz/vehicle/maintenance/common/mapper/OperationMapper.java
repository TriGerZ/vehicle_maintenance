package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import com.trigerz.vehicle.maintenance.persistence.model.OperationModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OperationMapper {
    public static OperationModel map(Operation operation){
        return new OperationModel(
                operation.getId(), operation.getType(), operation.getPeriodicityMileage(), operation.getPeriodicityMonth(),
                operation.getHistories().stream().map(OperationHistoryMapper::map).toList(),
                operation.getVehicle().getId()
        );
    }
}
