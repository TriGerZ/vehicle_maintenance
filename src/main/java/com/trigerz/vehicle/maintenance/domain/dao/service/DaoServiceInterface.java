package com.trigerz.vehicle.maintenance.domain.dao.service;

import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoDataIntegrityViolationException;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;

import java.util.List;

public interface DaoServiceInterface<T> {
    List<T> getAll();

    T getById(long id) throws DaoEntityNotFoundException;

    void save(T daoModel);

    void delete(long id) throws DaoDataIntegrityViolationException;
}
