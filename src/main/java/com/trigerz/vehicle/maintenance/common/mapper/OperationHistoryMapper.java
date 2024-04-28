package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.History;
import com.trigerz.vehicle.maintenance.persistence.model.OperationHistoryModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OperationHistoryMapper {
    public static OperationHistoryModel map(History history){
        return new OperationHistoryModel(
                history.getId(), history.getLink(), history.getPrice(), history.getComment(), history.getOperation().getId(),
                history.getDate(), history.getMileage()
        );
    }
}
