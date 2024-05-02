package com.trigerz.vehicle.maintenance.domain.dao.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Owner;
import com.trigerz.vehicle.maintenance.domain.model.OwnerModel;
import org.mapstruct.Mapper;

@Mapper(uses = {JpaOperationMapper.class, JpaAccessoryMapper.class, JpaVehicleMapper.class})
public interface JpaOwnerMapper {
  Owner mapOwnerModel(OwnerModel ownerModel);
}

