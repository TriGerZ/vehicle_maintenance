package com.trigerz.vehicle.maintenance.domain.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Accessory;
import com.trigerz.vehicle.maintenance.domain.model.AccessoryModel;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.AccessoryReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = VehicleMapper.class)
public interface AccessoryMapper {
    @Mapping(target = "vehicleId", source = "accessory.vehicle.id")
    AccessoryModel toAccessoryModel(Accessory accessory);
    @Mapping(target = "id", ignore = true)
    AccessoryModel toAccessoryModel(AccessoryReqDto accessoryReqDto);
}
