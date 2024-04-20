package com.trigerz.vehicle.maintenance.dao.mapper;

import com.trigerz.vehicle.maintenance.dao.model.OperationHistoryDao;
import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class OperationDaoMapper {
    public List<OperationHistoryDao> map(Operation operation) {
        return operation.getOperationHistory().stream().map(
                history ->
                        new OperationHistoryDao(history.getId(), history.getDate(), operation.getName(), operation.getPeriodicityDate(), operation.getPeriodicityKilometers(), operation.getId())

        ).toList();
    }
}
