package com.trigerz.vehicle.maintenance.rest.controller.advice;

import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityIntegrityException;
import com.trigerz.vehicle.maintenance.rest.dto.exception.DtoEntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DtoEntityNotFoundException.class})
    ProblemDetail handleEntityNotFound(DtoEntityNotFoundException ex) {
        ProblemDetail problemDetails = ProblemDetail
                .forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

        problemDetails.setType(URI.create("http://localhost:8080/errors/owner-not-found"));
        problemDetails.setTitle("Owner Not Found");
        problemDetails.setProperty("ownerId", ex.getId());
        return problemDetails;
    }

    @ExceptionHandler(value = {DtoEntityIntegrityException.class})
    ProblemDetail handleEntityIntegrity(DtoEntityIntegrityException ex) {
        ProblemDetail problemDetails = ProblemDetail
                .forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());

        problemDetails.setType(URI.create("http://localhost:8080/errors/owner-integrity"));
        problemDetails.setTitle("Owner Integrity not respected");
        problemDetails.setProperty("ownerId", ex.getId());
        return problemDetails;
    }

}