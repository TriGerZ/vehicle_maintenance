package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.common.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.persistence.model.VehicleDao;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class VehicleService implements DaoServiceInterface<VehicleDao>{
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDao> getAll() {
        return vehicleRepository.findAll()
                .stream().map(VehicleMapper::map)
                .toList();
    }

    @Override
    public VehicleDao getById(long id) {
        return VehicleMapper.map(vehicleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vehicle not found")));
    }

    @Override
    public void save(VehicleDao vehicleDao) {
        vehicleRepository.save(map(vehicleDao));
    }

    @Override
    public void delete(long id) {
        vehicleRepository.deleteById(id);
    }

    private static Vehicle map(VehicleDao vehicleDao){
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDao.name());
        vehicle.setCurrentKilometers(vehicleDao.currentKilometers());
        return vehicle;
    }
}
