package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import org.springframework.data.repository.ListCrudRepository;

public interface VehicleRepository extends ListCrudRepository<Vehicle, Long> {
}
