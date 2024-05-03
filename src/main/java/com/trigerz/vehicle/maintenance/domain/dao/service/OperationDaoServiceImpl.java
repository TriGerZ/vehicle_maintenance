package com.trigerz.vehicle.maintenance.domain.dao.service;

import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaOperationMapper;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.OperationMapper;
import com.trigerz.vehicle.maintenance.domain.model.OperationModel;
import com.trigerz.vehicle.maintenance.persistence.repository.OperationRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public class OperationDaoServiceImpl implements OperationDaoService {
    private final OperationRepository operationRepository;
    private final OperationMapper operationMapper;
    private final JpaOperationMapper jpaOperationMapper;

    public OperationDaoServiceImpl(OperationRepository operationRepository, OperationMapper operationMapper, JpaOperationMapper jpaOperationMapper) {
        this.operationRepository = operationRepository;
        this.operationMapper = operationMapper;
        this.jpaOperationMapper = jpaOperationMapper;
    }

    @Override
    public List<OperationModel> getAll() {
        return operationRepository.findAll().stream().map(operationMapper::toOperationModel).toList();
    }

    @Override
    public OperationModel getById(long id) throws DaoEntityNotFoundException {
        return operationMapper.toOperationModel(operationRepository.findById(id).orElseThrow(() -> new DaoEntityNotFoundException("not found")));
    }

    @Override
    public void save(OperationModel daoM) {
        operationRepository.save(jpaOperationMapper.mapOperationModel(daoM));
    }

    @Override
    public void delete(long id) throws DaoDataIntegrityViolationException {
        try {
            operationRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DaoDataIntegrityViolationException(e.getMessage(), e);
        }
    }
}
