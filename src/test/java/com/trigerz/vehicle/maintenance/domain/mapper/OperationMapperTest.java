package com.trigerz.vehicle.maintenance.domain.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.History;
import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import com.trigerz.vehicle.maintenance.persistence.entity.Vehicle;
import com.trigerz.vehicle.maintenance.domain.model.OperationHistoryModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationMapperTest {

    @InjectMocks
    OperationMapper mapper = Mappers.getMapper(OperationMapper.class);

    @Mock
    OperationHistoryMapper historyMapper;

    @Test
    void whenMapsOperationToOperationModelThenTrue() {
        //Given
        Operation operation = new Operation();
        operation.setId(4);
        operation.setType("Operation");
        operation.setPeriodicityMonth(4);
        operation.setPeriodicityMileage(4000);
        Vehicle vehicle = new Vehicle();
        vehicle.setId(1);
        operation.setVehicle(vehicle);
        History e1 = new History();
        operation.setHistories(Set.of(e1));
        when(historyMapper.toOperationHistoryModel(e1)).thenReturn(new OperationHistoryModel());
        //When
        var actual = mapper.toOperationModel(operation);
        //Then
        assertEquals(operation.getId(), actual.getId());
        assertEquals(operation.getType(), actual.getType());
        assertEquals(operation.getPeriodicityMonth(), actual.getPeriodicityMonth());
        assertEquals(operation.getPeriodicityMileage(), actual.getPeriodicityMileage());
        assertEquals(operation.getVehicle().getId(), actual.getVehicleId());
        assertEquals(operation.getHistories().size(), actual.getHistories().size());
    }
}