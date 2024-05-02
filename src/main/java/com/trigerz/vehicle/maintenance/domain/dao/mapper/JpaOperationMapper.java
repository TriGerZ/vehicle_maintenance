package com.trigerz.vehicle.maintenance.domain.dao.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import com.trigerz.vehicle.maintenance.domain.model.OperationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = JpaHistoryMapper.class)
public interface JpaOperationMapper {
    @Mapping(target = "vehicle.id", source = "operationModel.vehicleId")
    Operation mapOperationModel(OperationModel operationModel);
}

