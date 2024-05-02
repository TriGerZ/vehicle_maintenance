package com.trigerz.vehicle.maintenance.domain.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import com.trigerz.vehicle.maintenance.domain.model.OperationModel;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {OperationHistoryMapper.class, VehicleMapper.class})
public interface OperationMapper {
  @Mapping(target = "vehicleId", source = "operation.vehicle.id")
  OperationModel toOperationModel(Operation operation);
  @Mapping(target = "id", ignore = true)
  OperationModel toOperationModel(OperationReqDto operationReqDto);
  OperationResDto toOperationResDto(OperationModel operationModel);
}
