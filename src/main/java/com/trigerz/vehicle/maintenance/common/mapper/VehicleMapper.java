package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.model.VehicleDao;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.rest.model.VehicleBasicDto;
import com.trigerz.vehicle.maintenance.rest.model.VehicleBasicReqDto;

public class VehicleMapper {
    public static VehicleDao map(Vehicle vehicle) {
        return new VehicleDao(
                vehicle.getId(), vehicle.getName(), vehicle.getCurrentKilometers(),
                vehicle.getOperations()
                        .stream()
                        .map(OperationMapper::map)
                        .toList()
        );
    }

    public static VehicleBasicDto map(VehicleDao vehicleDao) {
        return new VehicleBasicDto(vehicleDao.id(), vehicleDao.name());
    }

    public static VehicleDao map(VehicleBasicReqDto vehicleBasicReqDto) {
        return new VehicleDao(vehicleBasicReqDto.name(), vehicleBasicReqDto.currentKilometers());
    }
}
