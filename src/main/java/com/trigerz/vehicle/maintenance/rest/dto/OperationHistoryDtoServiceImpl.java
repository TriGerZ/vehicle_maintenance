package com.trigerz.vehicle.maintenance.rest.dto;

import com.trigerz.vehicle.maintenance.domain.dao.service.OperationHistoryDaoService;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.OperationHistoryMapper;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityIntegrityException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.rest.dto.model.request.OperationHistoryReqDto;
import com.trigerz.vehicle.maintenance.rest.dto.model.response.OperationHistoryResDto;

import java.util.List;

public class OperationHistoryDtoServiceImpl implements OperationHistoryDtoService {

    private final OperationHistoryDaoService operationHistoryDaoService;
    private final OperationHistoryMapper operationHistoryMapper;

    public OperationHistoryDtoServiceImpl(OperationHistoryDaoService operationHistoryDaoService, OperationHistoryMapper operationHistoryMapper) {
        this.operationHistoryDaoService = operationHistoryDaoService;
        this.operationHistoryMapper = operationHistoryMapper;
    }

    @Override
    public List<OperationHistoryResDto> getAll() {
        return operationHistoryDaoService.getAll().stream().map(operationHistoryMapper::toOperationHistoryResDto).toList();
    }

    @Override
    public OperationHistoryResDto getById(long id) throws DtoEntityNotFoundException {
        try {
            return operationHistoryMapper.toOperationHistoryResDto(operationHistoryDaoService.getById(id));
        } catch (DaoEntityNotFoundException e) {
            throw new DtoEntityNotFoundException(id);
        }
    }

    @Override
    public void save(OperationHistoryReqDto dtoM) {
        operationHistoryDaoService.save(operationHistoryMapper.toOperationHistoryModel(dtoM));
    }

    @Override
    public void delete(long id) throws DtoEntityIntegrityException {
        try {
            operationHistoryDaoService.delete(id);
        } catch (DaoDataIntegrityViolationException e) {
            throw new DtoEntityIntegrityException(id);
        }
    }
}
