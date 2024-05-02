package com.trigerz.vehicle.maintenance.domain.dao.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.domain.model.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {JpaAccessoryMapper.class, JpaOperationMapper.class})
public interface JpaVehicleMapper {
    @Mapping(target = "owner.id", source = "vehicleModel.ownerId")
    Vehicle mapVehicleModel(VehicleModel vehicleModel);

}

