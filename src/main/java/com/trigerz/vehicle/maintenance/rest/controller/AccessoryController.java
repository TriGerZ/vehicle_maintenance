package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.model.request.AccessoryReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.AccessoryResDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/accessories")
public interface AccessoryController extends CrudController<AccessoryReqDto, AccessoryResDto> {
}
