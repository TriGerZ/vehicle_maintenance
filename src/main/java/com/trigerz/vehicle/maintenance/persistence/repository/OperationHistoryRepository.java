package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.OperationHistory;
import org.springframework.data.repository.ListCrudRepository;

public interface OperationHistoryRepository extends ListCrudRepository<OperationHistory, Long> {
}
