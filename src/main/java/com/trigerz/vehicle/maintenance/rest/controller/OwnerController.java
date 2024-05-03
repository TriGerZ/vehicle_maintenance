package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.model.request.OwnerReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OwnerResDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(("/owners"))
public interface OwnerController extends CrudController<OwnerReqDto, OwnerResDto> {
}
