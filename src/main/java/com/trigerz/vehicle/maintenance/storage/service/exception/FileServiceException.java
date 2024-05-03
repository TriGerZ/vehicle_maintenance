package com.trigerz.vehicle.maintenance.storage.service.exception;

public class FileServiceException extends RuntimeException {
    public FileServiceException(Exception e) {
        super(e.getMessage(), e);
    }
}
