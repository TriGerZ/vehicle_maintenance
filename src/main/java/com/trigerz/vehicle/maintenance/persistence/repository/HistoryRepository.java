package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.History;
import org.springframework.data.repository.ListCrudRepository;

public interface HistoryRepository extends ListCrudRepository<History, Long> {
}
