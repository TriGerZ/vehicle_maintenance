package com.trigerz.vehicle.maintenance.persistence.model;

import java.time.LocalDate;
import java.util.List;

public record OperationDao(Integer id, String name, LocalDate periodicityDate, Integer periodicityKilometers,
                           List<LocalDate> historic) {
}
