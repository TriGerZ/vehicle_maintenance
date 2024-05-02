package com.trigerz.vehicle.maintenance.domain.dao.service;

import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaOwnerMapper;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.OwnerMapper;
import com.trigerz.vehicle.maintenance.domain.model.OwnerModel;
import com.trigerz.vehicle.maintenance.persistence.repository.OwnerRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

public class OwnerDaoService implements DaoServiceInterface<OwnerModel> {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    private final JpaOwnerMapper jpaMapper;

    public OwnerDaoService(OwnerRepository ownerRepository, OwnerMapper ownerMapper, JpaOwnerMapper jpaMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
        this.jpaMapper = jpaMapper;
    }

    @Override
    public List<OwnerModel> getAll() {
        return ownerRepository.findAll().stream().map(ownerMapper::toOwnerModel).toList();
    }

    @Override
    public OwnerModel getById(long id) throws DaoEntityNotFoundException {
        return ownerRepository.findById(id).map(ownerMapper::toOwnerModel).orElseThrow(() -> new DaoEntityNotFoundException("Owner not found"));
    }

    @Override
    public void save(OwnerModel daoModel) {
        ownerRepository.save(jpaMapper.mapOwnerModel(daoModel));
    }

    @Override
    public void delete(long id) throws DaoDataIntegrityViolationException {
        try {
            ownerRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DaoDataIntegrityViolationException(e.getMessage(), e);
        }
    }
}
