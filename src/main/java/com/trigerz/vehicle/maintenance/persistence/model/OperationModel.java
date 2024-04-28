package com.trigerz.vehicle.maintenance.persistence.model;

import com.trigerz.vehicle.maintenance.util.DateUtils;

import java.util.List;

public record OperationModel(
        Integer id,
        String type,
        Integer periodicityMileage,
        Integer periodicityMonth,
        List<OperationHistoryModel> operationHistoryModelList,
        Integer vehicleId
) {
    public boolean hasToBeExecuted(int currentMileage) {
        var expiredByMileage = operationHistoryModelList.stream().noneMatch(
                operationHistoryModel -> mileageLowerThanPeriodicity(operationHistoryModel, currentMileage)
        );
        var expiredByMonth = operationHistoryModelList.stream().noneMatch(this::dateLowerThanPeriodicity);
        return expiredByMileage || expiredByMonth;

    }

    private boolean mileageLowerThanPeriodicity(OperationHistoryModel operationHistoryModel, int currentMileage) {
        return (currentMileage - operationHistoryModel.mileage()) < periodicityMileage;
    }

    private boolean dateLowerThanPeriodicity(OperationHistoryModel operationHistoryModel) {
        return DateUtils.differenceInMonthWithToday(operationHistoryModel.date()) < periodicityMonth;
    }
}
