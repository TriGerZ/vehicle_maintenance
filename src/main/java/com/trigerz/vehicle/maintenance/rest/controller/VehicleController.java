package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.common.mapper.VehicleDaoMapper;
import com.trigerz.vehicle.maintenance.persistence.service.VehicleDaoService;
import com.trigerz.vehicle.maintenance.rest.model.VehicleBasicDto;
import com.trigerz.vehicle.maintenance.rest.model.VehicleBasicReqDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    private final VehicleDaoService vehicleDaoService;

    public VehicleController(VehicleDaoService vehicleDaoService) {
        this.vehicleDaoService = vehicleDaoService;
    }

    @GetMapping("/vehicles")
    public List<VehicleBasicDto> getVehicleBasicDto() {
        return vehicleDaoService.getAll()
                .stream().map(VehicleDaoMapper::map)
                .toList();
    }

    @PostMapping("/vehicles")
    public void addVehicleBasicDto(@RequestBody VehicleBasicReqDto vehicleBasicReqDto) {
        vehicleDaoService.save(VehicleDaoMapper.map(vehicleBasicReqDto));
    }
}
