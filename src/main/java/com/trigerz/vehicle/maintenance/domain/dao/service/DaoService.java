package com.trigerz.vehicle.maintenance.domain.dao.service;

import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;

import java.util.List;

public interface DaoService<M> {
    List<M> getAll();

    M getById(long id) throws DaoEntityNotFoundException;

    void save(M daoM);

    void delete(long id) throws DaoDataIntegrityViolationException;
}
