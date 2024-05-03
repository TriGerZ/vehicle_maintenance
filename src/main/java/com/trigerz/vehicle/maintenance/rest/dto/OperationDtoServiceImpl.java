package com.trigerz.vehicle.maintenance.rest.dto;

import com.trigerz.vehicle.maintenance.domain.dao.service.OperationDaoService;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.OperationMapper;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityIntegrityException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationResDto;

import java.util.List;

public class OperationDtoServiceImpl implements OperationDtoService {

    private final OperationDaoService operationDaoService;
    private final OperationMapper operationMapper;

    public OperationDtoServiceImpl(OperationDaoService operationDaoService, OperationMapper operationMapper) {
        this.operationDaoService = operationDaoService;
        this.operationMapper = operationMapper;
    }

    @Override
    public List<OperationResDto> getAll() {
        return operationDaoService.getAll().stream().map(operationMapper::toOperationResDto).toList();
    }

    @Override
    public OperationResDto getById(long id) throws DtoEntityNotFoundException {
        try {
            return operationMapper.toOperationResDto(operationDaoService.getById(id));
        } catch (DaoEntityNotFoundException e) {
            throw new DtoEntityNotFoundException(id);
        }
    }

    @Override
    public void save(OperationReqDto dtoM) {
        operationDaoService.save(operationMapper.toOperationModel(dtoM));
    }

    @Override
    public void delete(long id) throws DtoEntityIntegrityException {
        try {
            operationDaoService.delete(id);
        } catch (DaoDataIntegrityViolationException e) {
            throw new DtoEntityIntegrityException(id);
        }
    }
}
