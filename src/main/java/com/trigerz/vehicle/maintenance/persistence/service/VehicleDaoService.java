package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.common.mapper.VehicleDaoMapper;
import com.trigerz.vehicle.maintenance.persistence.model.VehicleDao;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class VehicleDaoService {
    private final VehicleRepository vehicleRepository;

    public VehicleDaoService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<VehicleDao> getAll() {
        return vehicleRepository.findAll()
                .stream().map(VehicleDaoMapper::map)
                .toList();
    }

    public VehicleDao get(Long id) {
        return VehicleDaoMapper.map(vehicleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vehicle not found")));
    }

    public void save(VehicleDao vehicleDao) {
        vehicleRepository.save(map(vehicleDao));
    }

    public void delete(Long id) {
        vehicleRepository.deleteById(id);
    }

    private static Vehicle map(VehicleDao vehicleDao){
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDao.name());
        vehicle.setCurrentKilometers(vehicleDao.currentKilometers());
        return vehicle;
    }
}
