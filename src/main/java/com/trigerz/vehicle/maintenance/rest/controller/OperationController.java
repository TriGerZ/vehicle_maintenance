package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationResDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/operations")
public interface OperationController extends CrudController<OperationReqDto, OperationResDto> {
}
