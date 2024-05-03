package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.Accessory;
import org.springframework.data.repository.ListCrudRepository;

public interface AccessoryRepository extends ListCrudRepository<Accessory, Long> {
}
