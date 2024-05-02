package com.trigerz.vehicle.maintenance.domain.dao.service;

import com.trigerz.vehicle.maintenance.domain.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.domain.model.VehicleModel;
import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaVehicleMapper;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;

import java.util.List;

public class VehicleDaoService implements DaoServiceInterface<VehicleModel> {
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final JpaVehicleMapper jpaMapper;

    public VehicleDaoService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, JpaVehicleMapper jpaMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public List<VehicleModel> getAll() {
        return vehicleRepository.findAll().stream().map(vehicleMapper::mapVehicleModel).toList();
    }

    @Override
    public VehicleModel getById(long id) throws DaoEntityNotFoundException {
        return vehicleRepository.findById(id).map(vehicleMapper::mapVehicleModel).orElseThrow(() -> new DaoEntityNotFoundException("Vehicle not found"));
    }

    @Override
    public void save(VehicleModel daoModel) {
        vehicleRepository.save(jpaMapper.mapVehicleModel(daoModel));
    }

    @Override
    public void delete(long id) {
        vehicleRepository.deleteById(id);
    }

}