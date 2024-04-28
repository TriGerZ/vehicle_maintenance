package com.trigerz.vehicle.maintenance.rest.controller;

import com.trigerz.vehicle.maintenance.common.mapper.OwnerMapper;
import com.trigerz.vehicle.maintenance.persistence.service.OwnerDaoService;
import com.trigerz.vehicle.maintenance.rest.model.OwnerResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OwnerController {

    private final OwnerDaoService ownerDaoService;

    public OwnerController(OwnerDaoService ownerDaoService) {
        this.ownerDaoService = ownerDaoService;
    }

    @GetMapping("/owners")
    public List<OwnerResDto> getAllOwners() {
        return ownerDaoService.getAll().stream().map(OwnerMapper::map).toList();
    }
}
