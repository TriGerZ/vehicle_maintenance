package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.common.mapper.OperationMapper;
import com.trigerz.vehicle.maintenance.persistence.model.OperationDao;
import com.trigerz.vehicle.maintenance.persistence.repository.OperationRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class OperationService implements DaoServiceInterface<OperationDao> {
    private final OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public List<OperationDao> getAll() {
        return operationRepository.findAll().stream().map(OperationMapper::map).toList();
    }

    @Override
    public OperationDao getById(long id) {
        return operationRepository.findById(id).map(OperationMapper::map).orElseThrow(() -> new EntityNotFoundException("Operation not found"));
    }

    @Override
    public void save(OperationDao daoModel) {
        operationRepository.save(OperationMapper.map(daoModel));
    }

    @Override
    public void delete(long id) {

    }
}
