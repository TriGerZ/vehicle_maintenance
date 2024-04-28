package com.trigerz.vehicle.maintenance.common.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.Accessory;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.persistence.model.AccessoryModel;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccessoryMapperTest {

    @Test
    void map() {
        //given
        Accessory accessory = new Accessory();
        accessory.setId(1);
        accessory.setName("test");
        accessory.setPrice(BigDecimal.valueOf(10));
        LocalDate purchaseDate = LocalDate.of(2000, 11, 2);
        accessory.setPurchaseDate(purchaseDate);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(9);
        accessory.setVehicle(vehicle);

        AccessoryModel expected = new AccessoryModel(1, "test", BigDecimal.valueOf(10), purchaseDate, 9);
        //when
        var actual = AccessoryMapper.map(accessory);
        //Then
        assertEquals(expected, actual);
    }
}