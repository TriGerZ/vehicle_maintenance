package com.trigerz.vehicle.maintenance.domain.dao.service;

import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaAccessoryMapper;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.AccessoryMapper;
import com.trigerz.vehicle.maintenance.domain.model.AccessoryModel;
import com.trigerz.vehicle.maintenance.persistence.repository.AccessoryRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public class AccessoryDaoServiceImpl implements AccessoryDaoService {

    private final AccessoryRepository accessoryRepository;
    private final JpaAccessoryMapper jpaAccessoryMapper;
    private final AccessoryMapper accessoryMapper;

    public AccessoryDaoServiceImpl(AccessoryRepository accessoryRepository, JpaAccessoryMapper jpaAccessoryMapper, AccessoryMapper accessoryMapper) {
        this.accessoryRepository = accessoryRepository;
        this.jpaAccessoryMapper = jpaAccessoryMapper;
        this.accessoryMapper = accessoryMapper;
    }

    @Override
    public List<AccessoryModel> getAll() {
        return accessoryRepository.findAll().stream().map(accessoryMapper::toAccessoryModel).toList();
    }

    @Override
    public AccessoryModel getById(long id) throws DaoEntityNotFoundException {
        return accessoryMapper.toAccessoryModel(accessoryRepository.findById(id).orElseThrow(() -> new DaoEntityNotFoundException("not found")));
    }

    @Override
    public void save(AccessoryModel daoM) {
        accessoryRepository.save(jpaAccessoryMapper.mapAccessoryModel(daoM));
    }

    @Override
    public void delete(long id) throws DaoDataIntegrityViolationException {
        try {
            accessoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DaoDataIntegrityViolationException(e.getMessage(), e);
        }
    }
}
