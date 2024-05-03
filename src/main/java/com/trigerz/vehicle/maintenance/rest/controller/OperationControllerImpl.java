package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.OperationDtoService;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationResDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationControllerImpl implements OperationController {

    private final OperationDtoService operationDtoService;

    public OperationControllerImpl(OperationDtoService operationDtoService) {
        this.operationDtoService = operationDtoService;
    }

    @Override
    public List<OperationResDto> getAll() {
        return operationDtoService.getAll();
    }

    @Override
    public OperationResDto getById(int id) {
        return operationDtoService.getById(id);
    }

    @Override
    public void create(OperationReqDto req) {
        operationDtoService.save(req);
    }

    @Override
    public void deleteById(int id) {
        operationDtoService.delete(id);
    }
}
