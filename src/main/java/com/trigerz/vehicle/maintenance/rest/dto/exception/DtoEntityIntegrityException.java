package com.trigerz.vehicle.maintenance.rest.dto.exception;

import lombok.Getter;

@Getter
public class DtoEntityIntegrityException extends RuntimeException {
    private final Long id;
    public DtoEntityIntegrityException(Long id) {
        super("Customer "+id+" integrity issue!");
        this.id = id;
    }
}
