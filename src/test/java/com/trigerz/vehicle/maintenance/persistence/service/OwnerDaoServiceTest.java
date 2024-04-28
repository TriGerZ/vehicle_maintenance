package com.trigerz.vehicle.maintenance.persistence.service;

import com.trigerz.vehicle.maintenance.persistence.entity.Owner;
import com.trigerz.vehicle.maintenance.persistence.model.OwnerModel;
import com.trigerz.vehicle.maintenance.persistence.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerDaoServiceTest {

    @InjectMocks
    private OwnerDaoService ownerDaoService;
    @Mock
    private OwnerRepository ownerRepository;


    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldReturnListOfOwnerModelWhenGetAll() {
        //Given
        when(ownerRepository.findAll()).thenReturn(List.of(new Owner(), new Owner(), new Owner()));
        //when
        var owners = ownerDaoService.getAll();
        //Then
        assertEquals(3, owners.size());
    }

    @Test
    void shouldReturnOwnerModelGivenIdExistsWhenGetById() {
        //Given
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(new Owner()));
        //When
        var owner = ownerDaoService.getById(1);
        //Then
        assertNotNull(owner);
    }

    @Test
    void shouldPersistOwnerWhenSave() {
        //Given
        String name = "name";
        OwnerModel ownerModel = new OwnerModel(null, name,null);
        //When
        ownerDaoService.save(ownerModel);
        //Then
        verify(ownerRepository).save(argThat(
                argument -> argument.getName().equals(name) &&
                        argument.getVehicles().isEmpty()
        ));
    }

    @Test
    void delete() {

    }
}