package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.OperationHistoryDtoService;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationHistoryReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationHistoryResDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OperationHistoryControllerImpl implements OperationHistoryController {

    private final OperationHistoryDtoService operationHistoryDtoService;

    public OperationHistoryControllerImpl(OperationHistoryDtoService operationHistoryDtoService) {
        this.operationHistoryDtoService = operationHistoryDtoService;
    }

    @Override
    public List<OperationHistoryResDto> getAll() {
        return operationHistoryDtoService.getAll();
    }

    @Override
    public OperationHistoryResDto getById(int id) {
        return operationHistoryDtoService.getById(id);
    }

    @Override
    public void create(OperationHistoryReqDto req) {
        operationHistoryDtoService.save(req);
    }

    @Override
    public void deleteById(int id) {
        operationHistoryDtoService.delete(id);
    }
}
