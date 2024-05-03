package com.trigerz.vehicle.maintenance.rest.dto;

import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityIntegrityException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;

import java.util.List;

public interface DtoService<O, M> {

    List<O> getAll();

    O getById(long id) throws DtoEntityNotFoundException;

    void save(M dtoM);

    void delete(long id) throws DtoEntityIntegrityException;
}
