package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.domain.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.domain.dao.service.VehicleDaoService;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.VehicleResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/vehicles")
@RestController
public class VehicleController {

    private final VehicleDaoService vehicleDaoService;
    private final VehicleMapper vehicleMapper;

    public VehicleController(VehicleDaoService vehicleDaoService, VehicleMapper vehicleMapper) {
        this.vehicleDaoService = vehicleDaoService;
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping
    public List<VehicleResDto> getAllVehicles() {
        return vehicleDaoService.getAll().stream().map(vehicleMapper::mapVehicleDto).toList();
    }
}
