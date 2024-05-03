package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaOwnerMapper;
import com.trigerz.vehicle.maintenance.domain.dao.service.OwnerDaoService;
import com.trigerz.vehicle.maintenance.domain.dao.service.exception.DaoEntityNotFoundException;
import com.trigerz.vehicle.maintenance.domain.mapper.OwnerMapper;
import com.trigerz.vehicle.maintenance.domain.model.OwnerModel;
import com.trigerz.vehicle.maintenance.persistence.entity.Owner;
import com.trigerz.vehicle.maintenance.persistence.repository.OwnerRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerDaoServiceImplTest {

    @InjectMocks
    private OwnerDaoService ownerDaoService;
    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private OwnerMapper ownerMapper;
    @Mock
    private JpaOwnerMapper jpaOwnerMapper;

    @Test
    void shouldReturnAllOwnersWhenGetAll() {
        //Given
        var ownerArrayList = List.of(new Owner(), new Owner());
        when(ownerRepository.findAll()).thenReturn(ownerArrayList);
        //When
        var actual = ownerDaoService.getAll();
        //Then
        assertEquals(2, actual.size());
    }

    @Test
    void shouldReturnOwnerWhenGetById() {
        //Given
        var owner = new Owner();
        owner.setId(66);
        when(ownerRepository.findById(66L)).thenReturn(Optional.of(owner));
        OwnerModel ownerModel = new OwnerModel();
        ownerModel.setId(66);
        when(ownerMapper.toOwnerModel(owner)).thenReturn(ownerModel);
        //When
        OwnerModel actual;
        try {
            actual = ownerDaoService.getById(owner.getId());
        } catch (DaoEntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        //Then
        assertEquals(66, actual.getId());
    }

    @Test
    void shouldReturnExceptionGivenOwnerNotFoundWhenGetById() {
        //When & Then
        var actual = assertThrows(DaoEntityNotFoundException.class, () -> ownerDaoService.getById(404L));
        assertEquals("Owner not found", actual.getMessage());
    }

    @Test
    void shouldSaveOwnerWhenSave() {
        //Given
        var owner = new Owner();
        OwnerModel daoModel = new OwnerModel();
        when(jpaOwnerMapper.mapOwnerModel(daoModel)).thenReturn(owner);
        //When
        ownerDaoService.save(daoModel);
        //Then
        verify(ownerRepository).save(owner);
    }

    @SneakyThrows
    @Test
    void shouldDeleteOwnerWhenDelete() {
        //Given
        var owner = new Owner();
        owner.setId(66);
        //When
        ownerDaoService.delete(66);
        //Then
        verify(ownerRepository).deleteById(66L);
    }
    
}