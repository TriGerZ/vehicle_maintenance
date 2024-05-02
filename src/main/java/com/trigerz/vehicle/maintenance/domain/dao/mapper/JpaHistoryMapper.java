package com.trigerz.vehicle.maintenance.domain.dao.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.History;
import com.trigerz.vehicle.maintenance.domain.model.OperationHistoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface JpaHistoryMapper {
    @Mapping(target = "operation.id", source = "historyModel.operationId")
    History mapHistoryModel(OperationHistoryModel historyModel);
}

