package com.trigerz.vehicle.maintenance.persistence.repository;

import com.trigerz.vehicle.maintenance.persistence.entity.Invoice;
import org.springframework.data.repository.ListCrudRepository;

public interface InvoiceRepository extends ListCrudRepository<Invoice, Long> {
}
