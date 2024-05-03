package com.trigerz.vehicle.maintenance.rest.dto;

import com.trigerz.vehicle.maintenance.domain.dao.service.VehicleDaoService;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityIntegrityException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.VehicleReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.VehicleResDto;

import java.util.List;

public class VehicleDtoServiceImpl implements VehicleDtoService {

    private final VehicleDaoService vehicleDaoService;
    private final VehicleMapper vehicleMapper;

    public VehicleDtoServiceImpl(VehicleDaoService vehicleDaoService, VehicleMapper vehicleMapper) {
        this.vehicleDaoService = vehicleDaoService;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public List<VehicleResDto> getAll() {
        return vehicleDaoService.getAll().stream().map(vehicleMapper::mapVehicleDto).toList();
    }

    @Override
    public VehicleResDto getById(long id) throws DtoEntityNotFoundException {
        try {
            return vehicleMapper.mapVehicleDto(vehicleDaoService.getById(id));
        } catch (DaoEntityNotFoundException e) {
            throw new DtoEntityNotFoundException(id);
        }
    }

    @Override
    public void save(VehicleReqDto daoM) {
        vehicleDaoService.save(vehicleMapper.mapVehicleModel(daoM));
    }

    @Override
    public void delete(long id) throws DtoEntityIntegrityException {
        try {
            vehicleDaoService.delete(id);
        } catch (DaoDataIntegrityViolationException e) {
            throw new DtoEntityNotFoundException(id);
        }
    }
}
