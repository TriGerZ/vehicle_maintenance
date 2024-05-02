package com.trigerz.vehicle.maintenance.domain.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.domain.model.VehicleModel;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.VehicleReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.BasicVehicleResDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.VehicleResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {AccessoryMapper.class, OperationMapper.class})
public interface VehicleMapper {
    @Mapping(target = "ownerId", source = "owner.id")
    @Mapping(target = "operationsToPerformed", ignore = true)
    VehicleModel mapVehicleModel(Vehicle vehicle);
    BasicVehicleResDto vehicleBasicResDto(VehicleModel vehicleModel);
    VehicleResDto mapVehicleDto(VehicleModel vehicleModel);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastMileageUpdate", ignore = true)
    @Mapping(target = "operationsToPerformed", ignore = true)
    VehicleModel mapVehicleModel(VehicleReqDto vehicleReqDto);
}
