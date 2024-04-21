package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.common.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.persistence.service.VehicleService;
import com.trigerz.vehicle.maintenance.rest.model.VehicleBasicDto;
import com.trigerz.vehicle.maintenance.rest.model.VehicleBasicReqDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public List<VehicleBasicDto> getVehicleBasicDto() {
        return vehicleService.getAll()
                .stream().map(VehicleMapper::map)
                .toList();
    }

    @PostMapping("/vehicles")
    public void addVehicleBasicDto(@RequestBody VehicleBasicReqDto vehicleBasicReqDto) {
        vehicleService.save(VehicleMapper.map(vehicleBasicReqDto));
    }
}
