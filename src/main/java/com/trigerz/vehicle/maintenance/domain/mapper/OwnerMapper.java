package com.trigerz.vehicle.maintenance.domain.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Owner;
import com.trigerz.vehicle.maintenance.domain.model.OwnerModel;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OwnerReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OwnerResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = VehicleMapper.class)
public interface OwnerMapper {
  OwnerModel toOwnerModel(Owner owner);
  OwnerResDto toOwnerResDto(OwnerModel ownerModel);
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "vehicles", ignore = true)
  OwnerModel toOwnerModel(OwnerReqDto ownerReqDto);
}
