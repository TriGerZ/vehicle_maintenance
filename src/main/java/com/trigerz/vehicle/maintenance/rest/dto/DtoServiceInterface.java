package com.trigerz.vehicle.maintenance.rest.dto;

import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DtoServiceInterface<T,Q> {
    List<T> getAll();

    T getById(long id) throws DtoEntityNotFoundException;

    void save(Q dtoModel);

    void delete(long id);
}
