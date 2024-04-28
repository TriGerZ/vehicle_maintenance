package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.common.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.persistence.model.VehicleModel;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class VehicleDaoService implements DaoServiceInterface<VehicleModel> {
    private final VehicleRepository vehicleRepository;

    public VehicleDaoService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleModel> getAll() {
        return vehicleRepository.findAll().stream().map(VehicleMapper::map).toList();
    }

    @Override
    public VehicleModel getById(long id) {
        return vehicleRepository.findById(id).map(VehicleMapper::map).orElseThrow(() -> new EntityNotFoundException("Owner does not exist"));
    }

    @Override
    public void save(VehicleModel daoModel) {
        vehicleRepository.save(map(daoModel));
    }

    @Override
    public void delete(long id) {
        vehicleRepository.deleteById(id);
    }

    private Vehicle map(VehicleModel model) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(model.brand());
        vehicle.setModel(model.model());
        vehicle.setCurrentMileage(model.currentMileage());
        vehicle.setLastMileageUpdate(model.lastMileageUpdate());
        return vehicle;
    }
}
