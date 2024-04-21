package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.model.OperationDao;
import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import com.trigerz.vehicle.maintenance.persistence.entity.OperationHistory;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OperationMapper {
    public static OperationDao map(Operation operation) {
        return new OperationDao(operation.getId(), operation.getName(), operation.getPeriodicityDate(), operation.getPeriodicityKilometers(),
                operation.getOperationHistory().stream().map(OperationHistory::getDate).toList(),
                operation.getOperationHistory().stream().flatMap(operationHistory -> operationHistory.getInvoices().stream()).map(InvoiceMapper::map).toList()
        );
    }

    public static Operation map(OperationDao daoModel) {
        return Operation.builder()
                .name(daoModel.name())
                .periodicityDate(daoModel.periodicityDate())
                .periodicityKilometers(daoModel.periodicityKilometers())
                .build();
    }
}
