package com.trigerz.vehicle.maintenance.dao.mapper;

import com.trigerz.vehicle.maintenance.dao.model.VehicleDao;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;

import java.util.Collection;

public class VehicleDaoMapper {
    public static VehicleDao map(Vehicle vehicle) {
        return new VehicleDao(
                vehicle.getId(), vehicle.getName(), vehicle.getCurrentKilometers(),
                vehicle.getOperations().stream().map(OperationDaoMapper::map).flatMap(Collection::stream).toList()
        );
    }
}
