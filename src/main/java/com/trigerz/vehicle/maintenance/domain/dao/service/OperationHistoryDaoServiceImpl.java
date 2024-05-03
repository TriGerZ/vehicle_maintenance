package com.trigerz.vehicle.maintenance.domain.dao.service;

import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaHistoryMapper;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.OperationHistoryMapper;
import com.trigerz.vehicle.maintenance.domain.model.OperationHistoryModel;
import com.trigerz.vehicle.maintenance.persistence.repository.HistoryRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public class OperationHistoryDaoServiceImpl implements OperationHistoryDaoService {
    private final HistoryRepository historyRepository;
    private final OperationHistoryMapper operationHistoryMapper;
    private final JpaHistoryMapper jpaHistoryMapper;

    public OperationHistoryDaoServiceImpl(HistoryRepository historyRepository, OperationHistoryMapper operationHistoryMapper, JpaHistoryMapper jpaHistoryMapper) {
        this.historyRepository = historyRepository;
        this.operationHistoryMapper = operationHistoryMapper;
        this.jpaHistoryMapper = jpaHistoryMapper;
    }

    @Override
    public List<OperationHistoryModel> getAll() {
        return historyRepository.findAll().stream().map(operationHistoryMapper::toOperationHistoryModel).toList();
    }

    @Override
    public OperationHistoryModel getById(long id) throws DaoEntityNotFoundException {
        return operationHistoryMapper.toOperationHistoryModel(historyRepository.findById(id).orElseThrow(() -> new DaoEntityNotFoundException("not found")));
    }

    @Override
    public void save(OperationHistoryModel daoM) {
        historyRepository.save(jpaHistoryMapper.mapHistoryModel(daoM));
    }

    @Override
    public void delete(long id) throws DaoDataIntegrityViolationException {
        try {
            historyRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DaoDataIntegrityViolationException(e.getMessage(), e);
        }
    }
}
