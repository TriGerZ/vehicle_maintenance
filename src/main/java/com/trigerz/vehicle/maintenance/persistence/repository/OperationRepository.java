package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import org.springframework.data.repository.ListCrudRepository;

public interface OperationRepository extends ListCrudRepository<Operation, Long> {
}
