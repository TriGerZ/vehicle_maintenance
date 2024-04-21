package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.common.mapper.InvoiceMapper;
import com.trigerz.vehicle.maintenance.persistence.model.InvoiceDao;
import com.trigerz.vehicle.maintenance.persistence.repository.InvoiceRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class InvoiceService implements DaoServiceInterface<InvoiceDao>{
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<InvoiceDao> getAll() {
        return invoiceRepository.findAll().stream().map(InvoiceMapper::map).toList();
    }

    @Override
    public InvoiceDao getById(long id) {
        return InvoiceMapper.map(invoiceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Invoice not found")));
    }

    @Override
    public void save(InvoiceDao daoModel) {
        invoiceRepository.save(InvoiceMapper.map(daoModel));
    }

    @Override
    public void delete(long id) {
        invoiceRepository.deleteById(id);
    }
}
