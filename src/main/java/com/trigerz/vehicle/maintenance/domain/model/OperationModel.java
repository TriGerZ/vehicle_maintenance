package com.trigerz.vehicle.maintenance.domain.model;

import com.trigerz.vehicle.maintenance.util.DateUtils;
import com.trigerz.vehicle.maintenance.util.UndefinedDateException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public final class OperationModel {
    private Integer id;
    private OperationType type;
    private Integer periodicityMileage;
    private Integer periodicityMonth;
    private List<OperationHistoryModel> histories;
    private Integer vehicleId;

    public Boolean hasToBeExecuted(int currentMileage) {
        var expiredByMileage = histories.stream().noneMatch(
                operationHistoryModel -> mileageLowerThanPeriodicity(operationHistoryModel, currentMileage)
        );
        var expiredByMonth = histories.stream().noneMatch(this::dateLowerThanPeriodicity);
        return expiredByMileage || expiredByMonth;
    }

    private boolean mileageLowerThanPeriodicity(OperationHistoryModel operationHistoryModel, int currentMileage) {
        if (periodicityMileage == null) {
            return false;
        }
        return (currentMileage - operationHistoryModel.getMileage()) < periodicityMileage;
    }

    private boolean dateLowerThanPeriodicity(OperationHistoryModel operationHistoryModel) {
        if (periodicityMonth == null) {
            return false;
        }
        try {
            return DateUtils.differenceInMonthWithToday(operationHistoryModel.getDate()) < periodicityMonth;
        } catch (UndefinedDateException e) {
            return true;
        }
    }

}
