package com.trigerz.vehicle.maintenance.domain.dao.mapper;

import com.trigerz.vehicle.maintenance.domain.model.AccessoryModel;
import com.trigerz.vehicle.maintenance.persistence.entity.Accessory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface JpaAccessoryMapper {
    @Mapping(target = "vehicle.id", source = "accessoryModel.vehicleId")
    Accessory mapAccessoryModel(AccessoryModel accessoryModel);
}

