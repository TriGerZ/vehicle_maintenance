package com.trigerz.vehicle.maintenance.dao.model;

import java.time.LocalDate;

public record OperationHistoryDao(Integer id, LocalDate date, String name, LocalDate periodicityDate, Integer periodicityKilometers,
                                  Integer operationId) {
}
