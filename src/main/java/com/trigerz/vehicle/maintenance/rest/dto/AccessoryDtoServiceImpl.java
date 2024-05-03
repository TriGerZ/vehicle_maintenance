package com.trigerz.vehicle.maintenance.rest.dto;

import com.trigerz.vehicle.maintenance.domain.dao.service.AccessoryDaoService;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.AccessoryMapper;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityIntegrityException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.AccessoryReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.AccessoryResDto;

import java.util.List;

public class AccessoryDtoServiceImpl implements AccessoryDtoService {

    private final AccessoryDaoService accessoryDaoService;
    private final AccessoryMapper accessoryMapper;

    public AccessoryDtoServiceImpl(AccessoryDaoService accessoryDaoService, AccessoryMapper accessoryMapper) {
        this.accessoryDaoService = accessoryDaoService;
        this.accessoryMapper = accessoryMapper;
    }

    @Override
    public List<AccessoryResDto> getAll() {
        return accessoryDaoService.getAll().stream().map(accessoryMapper::toAccessoryResDto).toList();
    }

    @Override
    public AccessoryResDto getById(long id) throws DtoEntityNotFoundException {
        try {
            return accessoryMapper.toAccessoryResDto(accessoryDaoService.getById(id));
        } catch (DaoEntityNotFoundException e) {
            throw new DtoEntityNotFoundException(id);
        }
    }

    @Override
    public void save(AccessoryReqDto dtoM) {
        accessoryDaoService.save(accessoryMapper.toAccessoryModel(dtoM));
    }

    @Override
    public void delete(long id) throws DtoEntityIntegrityException {
        try {
            accessoryDaoService.delete(id);
        } catch (DaoDataIntegrityViolationException e) {
            throw new DtoEntityIntegrityException(id);
        }
    }
}
