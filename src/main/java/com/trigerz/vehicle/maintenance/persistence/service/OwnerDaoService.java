package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.common.mapper.OwnerMapper;
import com.trigerz.vehicle.maintenance.persistence.entity.Owner;
import com.trigerz.vehicle.maintenance.persistence.model.OwnerModel;
import com.trigerz.vehicle.maintenance.persistence.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class OwnerDaoService implements DaoServiceInterface<OwnerModel> {
    private final OwnerRepository ownerRepository;

    public OwnerDaoService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<OwnerModel> getAll() {
        return ownerRepository.findAll().stream().map(OwnerMapper::map).toList();
    }

    @Override
    public OwnerModel getById(long id) {
        return ownerRepository.findById(id).map(OwnerMapper::map).orElseThrow(() -> new EntityNotFoundException("Owner does not exist"));
    }

    @Override
    public void save(OwnerModel daoModel) {
        ownerRepository.save(map(daoModel));
    }

    @Override
    public void delete(long id) {
        ownerRepository.deleteById(id);
    }

    private Owner map(OwnerModel model){
        Owner owner = new Owner();
        owner.setName(model.name());
        return owner;
    }
}
