package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.persistence.model.VehicleDao;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleDaoServiceTest {

    @InjectMocks
    private VehicleDaoService vehicleDaoService;
    @Mock
    private VehicleRepository vehicleRepository;

    @Test
    void shouldSaveVehicle() {
        //Given
        String name = "vehicle1";
        int currentKilometers = 2304;
        VehicleDao vehicleDao = new VehicleDao(1, name, currentKilometers, List.of());
        Vehicle vehicle = Vehicle.builder().name(name).currentKilometers(currentKilometers).build();
        //When
        vehicleDaoService.save(vehicleDao);
        //Then
        verify(vehicleRepository).save(vehicle);
    }

    @Test
    void shouldGetAllVehicles() {
        //Given
        String name = "vehicle1";
        int currentKilometers = 2304;
        Vehicle vehicle = Vehicle.builder().id(1).name(name).currentKilometers(currentKilometers).build();
        Vehicle vehicle2 = Vehicle.builder().id(2).name(name).currentKilometers(currentKilometers).build();
        when(vehicleRepository.findAll()).thenReturn(List.of(vehicle, vehicle2));
        //When
        var current = vehicleDaoService.getAll();
        //Then
        assertEquals(2, current.size());
    }
}