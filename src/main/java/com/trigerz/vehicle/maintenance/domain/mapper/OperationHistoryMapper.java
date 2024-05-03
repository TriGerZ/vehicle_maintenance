package com.trigerz.vehicle.maintenance.domain.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.History;
import com.trigerz.vehicle.maintenance.domain.model.OperationHistoryModel;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationHistoryReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationHistoryResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = OperationMapper.class)
public interface OperationHistoryMapper {
  @Mapping(target = "operationId", source = "history.operation.id")
  OperationHistoryModel toOperationHistoryModel(History history);
  @Mapping(target = "id", ignore = true)
  OperationHistoryModel toOperationHistoryModel(OperationHistoryReqDto operationHistoryReqDto);
  OperationHistoryResDto toOperationHistoryResDto(OperationHistoryModel operationHistoryModel);
}
