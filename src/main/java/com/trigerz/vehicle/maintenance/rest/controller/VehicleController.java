package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.model.request.VehicleReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.VehicleResDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vehicles")
@RestController
public interface VehicleController extends CrudController<VehicleReqDto, VehicleResDto> {
}
