package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Accessory;
import com.trigerz.vehicle.maintenance.persistence.model.AccessoryModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccessoryMapper {
    public static AccessoryModel map(Accessory accessory){
        return new AccessoryModel(accessory.getId(),
                accessory.getName(),
                accessory.getPrice(),
                accessory.getPurchaseDate(),
                accessory.getVehicle().getId());
    }
}
