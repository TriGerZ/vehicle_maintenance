package com.trigerz.vehicle.maintenance.rest.dto.exception;

import lombok.Getter;

@Getter
public class DtoEntityNotFoundException extends RuntimeException {
    private final Long id;
    public DtoEntityNotFoundException(Long id) {
        super("Customer "+id+" not found!");
        this.id = id;
    }
}
