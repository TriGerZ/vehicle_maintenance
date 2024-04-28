package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.persistence.model.VehicleModel;
import com.trigerz.vehicle.maintenance.rest.model.VehicleBasicResDto;
import com.trigerz.vehicle.maintenance.rest.model.VehicleDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class VehicleMapper {
    public static VehicleModel map(Vehicle vehicle) {
        return new VehicleModel(
                vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getPurchaseDate()
                , vehicle.getCurrentMileage(), vehicle.getLastMileageUpdate(), vehicle.getPrice(),
                vehicle.getAccessories().stream().map(AccessoryMapper::map).toList(),
                vehicle.getOperations().stream().map(OperationMapper::map).toList(),
                vehicle.getOwner().getId()
        );
    }

    public static VehicleBasicResDto mapToVehicleBasicResDto(VehicleModel vehicleModel) {
        String vehicleName = String.format("%s - %s", vehicleModel.brand(), vehicleModel.model());
        return new VehicleBasicResDto(vehicleName, vehicleModel.currentMileage());
    }

    public static VehicleDto mapToVehicleDto(VehicleModel vehicleModel) {
        return new VehicleDto(vehicleModel.id(), vehicleModel.model(), vehicleModel.operationToExecute());
    }
}
