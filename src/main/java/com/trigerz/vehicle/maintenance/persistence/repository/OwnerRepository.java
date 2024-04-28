package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.Owner;
import org.springframework.data.repository.ListCrudRepository;

public interface OwnerRepository extends ListCrudRepository<Owner, Long> {
}
