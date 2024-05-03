package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.VehicleDtoService;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.VehicleReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.VehicleResDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleControllerImpl implements VehicleController {

    private final VehicleDtoService vehicleService;

    public VehicleControllerImpl(VehicleDtoService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public List<VehicleResDto> getAll() {
        return vehicleService.getAll();
    }

    @Override
    public VehicleResDto getById(int id) {
        return vehicleService.getById(id);
    }

    @Override
    public void create(VehicleReqDto req) {
        vehicleService.save(req);
    }

    @Override
    public void deleteById(int id) {
        vehicleService.delete(id);
    }
}
