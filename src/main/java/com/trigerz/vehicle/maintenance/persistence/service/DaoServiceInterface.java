package com.trigerz.vehicle.maintenance.persistence.service;

import java.util.List;

public interface DaoServiceInterface<T> {
    List<T> getAll();

    T getById(long id);

    void save(T daoModel);

    void delete(long id);
}
