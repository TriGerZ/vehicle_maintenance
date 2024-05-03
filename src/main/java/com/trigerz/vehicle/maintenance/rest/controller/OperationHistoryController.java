package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationHistoryReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationHistoryResDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/operation-histories")
public interface OperationHistoryController extends CrudController<OperationHistoryReqDto, OperationHistoryResDto> {
}
