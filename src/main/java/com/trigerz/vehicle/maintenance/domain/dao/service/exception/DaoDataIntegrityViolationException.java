package com.trigerz.vehicle.maintenance.domain.dao.service.exception;

public class DaoDataIntegrityViolationException extends Exception {
    public DaoDataIntegrityViolationException(String message, Exception e) {
        super(message, e);
    }
}
