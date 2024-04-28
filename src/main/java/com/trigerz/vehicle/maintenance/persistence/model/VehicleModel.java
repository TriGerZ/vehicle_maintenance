package com.trigerz.vehicle.maintenance.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record VehicleModel(
        Integer id, String brand, String model, LocalDate purchaseDate, Integer currentMileage, LocalDate lastMileageUpdate, BigDecimal price,
        List<AccessoryModel> accessoryModelList,
        List<OperationModel> operationModelList,
        Integer ownerId
) {
    public List<OperationModel> operationToExecute(){
        return operationModelList.stream().filter(
                operationModel -> operationModel.hasToBeExecuted(currentMileage)
        ).toList();
    }

    public boolean maintenanceNeeded(){
        return !operationToExecute().isEmpty();
    }

}
