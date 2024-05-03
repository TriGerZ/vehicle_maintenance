package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.rest.dto.AccessoryDtoService;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.AccessoryReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.AccessoryResDto;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccessoryControllerImpl implements AccessoryController {

    private final AccessoryDtoService accessoryDtoService;

    public AccessoryControllerImpl(AccessoryDtoService accessoryDtoService) {
        this.accessoryDtoService = accessoryDtoService;
    }

    @Override
    public List<AccessoryResDto> getAll() {
        return accessoryDtoService.getAll();
    }

    @Override
    public AccessoryResDto getById(int id) {
        return accessoryDtoService.getById(id);
    }

    @Override
    public void create(AccessoryReqDto req) {
        accessoryDtoService.save(req);
    }

    @Override
    public void deleteById(int id) {
        accessoryDtoService.delete(id);
    }
}
