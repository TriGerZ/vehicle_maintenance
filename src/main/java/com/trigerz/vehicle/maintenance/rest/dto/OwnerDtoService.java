package com.trigerz.vehicle.maintenance.rest.dto;

import com.trigerz.vehicle.maintenance.domain.dao.service.DaoServiceInterface;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.OwnerMapper;
import com.trigerz.vehicle.maintenance.domain.model.OwnerModel;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityIntegrityException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.BasicOwnerReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OwnerReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OwnerResDto;

import java.util.List;

public class OwnerDtoService implements DtoServiceInterface<OwnerResDto, OwnerReqDto> {
    private final DaoServiceInterface<OwnerModel> ownerDaoService;
    private final OwnerMapper ownerMapper;

    public OwnerDtoService(DaoServiceInterface<OwnerModel> ownerDaoService, OwnerMapper ownerMapper) {
        this.ownerDaoService = ownerDaoService;
        this.ownerMapper = ownerMapper;
    }


    @Override
    public List<OwnerResDto> getAll() {
        return ownerDaoService.getAll().stream().map(ownerMapper::toOwnerResDto).toList();
    }

    @Override
    public OwnerResDto getById(long id) throws DtoEntityNotFoundException {
        try {
            return ownerMapper.toOwnerResDto(ownerDaoService.getById(id));
        } catch (DaoEntityNotFoundException e) {
            throw new DtoEntityNotFoundException(id);
        }
    }

    @Override
    public void save(OwnerReqDto dtoModel) {
        ownerDaoService.save(ownerMapper.toOwnerModel(dtoModel));
    }

    public void save(BasicOwnerReqDto dtoModel) {
        ownerDaoService.save(ownerMapper.toOwnerModel(dtoModel));
    }

    @Override
    public void delete(long id) {
        try {
            ownerDaoService.delete(id);
        } catch (DaoDataIntegrityViolationException e) {
            throw new DtoEntityIntegrityException(id);
        }
    }
}
