package com.trigerz.vehicle.maintenance.domain.model;

import com.trigerz.vehicle.maintenance.util.DateUtils;
import com.trigerz.vehicle.maintenance.util.UndefinedDateException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public final class VehicleModel {

    public static final int MONTH_THRESHOLD = 3;
    private Integer id;
    private String brand;
    private String model;
    private LocalDate purchaseDate;
    private Integer currentMileage;
    private LocalDate lastMileageUpdate;
    private BigDecimal price;
    private List<AccessoryModel> accessories;
    private List<OperationModel> operations;
    private Integer ownerId;

    public List<OperationModel> getOperationsToPerformed() {
        return operations.stream().filter(operationModel -> operationModel.hasToBeExecuted(currentMileage)).toList();
    }

    public Boolean isObsoleteOperations() {
        var obsoleteOperations = getOperationsToPerformed();
        return obsoleteOperations != null && !obsoleteOperations.isEmpty();
    }

    public String getName() {
        return brand + " - " + model;
    }

    public Boolean isObsoleteMileage() {
        try {
            return DateUtils.differenceInMonthWithToday(lastMileageUpdate) > MONTH_THRESHOLD;
        } catch (UndefinedDateException e) {
            return true;
        }
    }

    public void setCurrentMileage(Integer currentMileage) {
        this.currentMileage = currentMileage;
        this.lastMileageUpdate = DateUtils.today();
    }

}
