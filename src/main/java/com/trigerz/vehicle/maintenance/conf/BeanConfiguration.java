package com.trigerz.vehicle.maintenance.conf;

import com.trigerz.vehicle.maintenance.domain.dao.mapper.*;
import com.trigerz.vehicle.maintenance.domain.dao.service.*;
import com.trigerz.vehicle.maintenance.domain.mapper.*;
import com.trigerz.vehicle.maintenance.persistence.repository.*;
import com.trigerz.vehicle.maintenance.rest.dto.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OwnerDaoService ownerDaoService(OwnerRepository ownerRepository, OwnerMapper ownerMapper, JpaOwnerMapper jpaMapper) {
        return new OwnerDaoServiceImpl(ownerRepository, ownerMapper, jpaMapper);
    }

    @Bean
    public VehicleDaoService vehicleDaoService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, JpaVehicleMapper jpaMapper) {
        return new VehicleDaoServiceImpl(vehicleRepository, vehicleMapper, jpaMapper);
    }

    @Bean
    public AccessoryDaoService accessoryDaoService(AccessoryRepository accessoryRepository, JpaAccessoryMapper jpaAccessoryMapper, AccessoryMapper accessoryMapper) {
        return new AccessoryDaoServiceImpl(accessoryRepository, jpaAccessoryMapper, accessoryMapper);
    }

    @Bean
    public OperationDaoService operationDaoService(OperationRepository operationRepository, OperationMapper operationMapper, JpaOperationMapper jpaOperationMapper) {
        return new OperationDaoServiceImpl(operationRepository, operationMapper, jpaOperationMapper);
    }

    @Bean
    public OperationHistoryDaoService operationHistoryDaoService(HistoryRepository historyRepository, OperationHistoryMapper operationHistoryMapper, JpaHistoryMapper jpaHistoryMapper){
        return new OperationHistoryDaoServiceImpl(historyRepository, operationHistoryMapper, jpaHistoryMapper);
    }

    @Bean
    public OwnerDtoService ownerDtoService(OwnerDaoService ownerDaoService, OwnerMapper ownerMapper) {
        return new OwnerDtoServiceImpl(ownerDaoService, ownerMapper);
    }

    @Bean
    public VehicleDtoService vehicleDtoService(VehicleDaoService daoService, VehicleMapper vehicleMapper){
        return new VehicleDtoServiceImpl(daoService, vehicleMapper);
    }

    @Bean
    public AccessoryDtoService accessoryDtoService(AccessoryDaoService daoService, AccessoryMapper accessoryMapper){
        return new AccessoryDtoServiceImpl(daoService, accessoryMapper);
    }

    @Bean
    public OperationDtoService operationDtoService(OperationDaoService daoService, OperationMapper operationMapper){
        return new OperationDtoServiceImpl(daoService, operationMapper);
    }

    @Bean
    public OperationHistoryDtoService operationHistoryDtoService(OperationHistoryDaoService daoService, OperationHistoryMapper operationHistoryMapper){
        return new OperationHistoryDtoServiceImpl(daoService, operationHistoryMapper);
    }
}
