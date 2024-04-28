package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Owner;
import com.trigerz.vehicle.maintenance.persistence.model.OwnerModel;
import com.trigerz.vehicle.maintenance.rest.model.OwnerResDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OwnerMapper {
    public static OwnerModel map(Owner model){
        return new OwnerModel(model.getId(), model.getName(),
                model.getVehicles().stream().map(VehicleMapper::map).toList()
        );
    }

    public static OwnerResDto map(OwnerModel model){
        return new OwnerResDto(model.id(), model.name(), model.vehicleModelList().stream().map(VehicleMapper::mapToVehicleBasicResDto).toList());
    }
}
