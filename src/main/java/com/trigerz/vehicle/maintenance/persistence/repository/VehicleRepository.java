package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
