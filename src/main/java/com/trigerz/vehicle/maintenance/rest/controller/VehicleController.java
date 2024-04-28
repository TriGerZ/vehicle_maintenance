package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.common.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.persistence.service.VehicleDaoService;
import com.trigerz.vehicle.maintenance.rest.model.VehicleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleDaoService vehicleDaoService;

    public VehicleController(VehicleDaoService vehicleDaoService) {
        this.vehicleDaoService = vehicleDaoService;
    }

    @GetMapping(name = "/vehicles")
    public List<VehicleDto> getAllVehicles() {
        return vehicleDaoService.getAll().stream().map(VehicleMapper::mapToVehicleDto).toList();
    }
}
