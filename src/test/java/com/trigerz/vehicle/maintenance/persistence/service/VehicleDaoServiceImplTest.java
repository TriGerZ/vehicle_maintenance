package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.domain.dao.service.VehicleDaoService;
import com.trigerz.vehicle.maintenance.domain.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.domain.model.VehicleModel;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaVehicleMapper;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleDaoServiceImplTest {

    @InjectMocks
    private VehicleDaoService vehicleDaoServiceImpl;
    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private VehicleMapper vehicleMapper;
    @Mock
    private JpaVehicleMapper jpaVehicleMapper;

    @Test
    void shouldReturnAllVehiclesWhenGetAll() {
        //Given
        var vehicleArrayList = List.of(new Vehicle(), new Vehicle());
        when(vehicleRepository.findAll()).thenReturn(vehicleArrayList);
        //When
        var actual = vehicleDaoServiceImpl.getAll();
        //Then
        assertEquals(2, actual.size());
    }

    @Test
    void shouldReturnVehicleWhenGetById() {
        //Given
        var vehicle = new Vehicle();
        vehicle.setId(66);
        when(vehicleRepository.findById(66L)).thenReturn(Optional.of(vehicle));
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setId(66);
        when(vehicleMapper.mapVehicleModel(vehicle)).thenReturn(vehicleModel);
        //When
        VehicleModel actual;
        try {
            actual = vehicleDaoServiceImpl.getById(vehicle.getId());
        } catch (DaoEntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Then
        assertEquals(66, actual.getId());
    }

    @Test
    void shouldReturnExceptionGivenVehicleNotFoundWhenGetById() {
        //When & Then
        var actual = assertThrows(DaoEntityNotFoundException.class, () -> vehicleDaoServiceImpl.getById(404L));
        assertEquals("Vehicle not found", actual.getMessage());
    }

    @Test
    void shouldSaveVehicleWhenSave() {
        //Given
        var vehicle = new Vehicle();
        VehicleModel daoModel = new VehicleModel();
        when(jpaVehicleMapper.mapVehicleModel(daoModel)).thenReturn(vehicle);
        //When
        vehicleDaoServiceImpl.save(daoModel);
        //Then
        verify(vehicleRepository).save(vehicle);
    }

    @SneakyThrows
    @Test
    void shouldDeleteVehicleWhenDelete() {
        //Given
        var vehicle = new Vehicle();
        vehicle.setId(66);
        //When
        vehicleDaoServiceImpl.delete(66);
        //Then
        verify(vehicleRepository).deleteById(66L);
    }
}