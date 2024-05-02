package com.trigerz.vehicle.maintenance.domain.mapper;

import com.trigerz.vehicle.maintenance.persistence.entity.History;
import com.trigerz.vehicle.maintenance.persistence.entity.Operation;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationHistoryMapperTest {

    OperationHistoryMapper operationHistoryMapper = Mappers.getMapper(OperationHistoryMapper.class);

    @Test
    void whenMapsOperationHistoryToOperationHistoryGivenHistoryToOperationHistoryThenTrue() {
        //Given
        History history = new History();
        Operation operation = new Operation();
        operation.setId(88);
        history.setOperation(operation);
        history.setComment("test");
        history.setDate(LocalDate.now());
        history.setId(5);
        history.setMileage(55);
        history.setPrice(BigDecimal.valueOf(405));
        //When
        var actual = operationHistoryMapper.toOperationHistoryModel(history);
        //Then
        assertEquals(history.getOperation().getId(), actual.getOperationId());
        assertEquals(history.getComment(), actual.getComment());
        assertEquals(history.getDate(), actual.getDate());
        assertEquals(history.getId(), actual.getId());
        assertEquals(history.getMileage(), actual.getMileage());
        assertEquals(history.getPrice(), actual.getPrice());
    }

}