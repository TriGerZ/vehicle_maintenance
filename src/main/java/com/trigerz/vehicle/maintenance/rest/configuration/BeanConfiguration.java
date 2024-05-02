package com.trigerz.vehicle.maintenance.rest.configuration;

import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaOwnerMapper;
import com.trigerz.vehicle.maintenance.domain.dao.mapper.JpaVehicleMapper;
import com.trigerz.vehicle.maintenance.domain.dao.service.DaoServiceInterface;
import com.trigerz.vehicle.maintenance.domain.dao.service.OwnerDaoService;
import com.trigerz.vehicle.maintenance.domain.dao.service.VehicleDaoService;
import com.trigerz.vehicle.maintenance.domain.mapper.OwnerMapper;
import com.trigerz.vehicle.maintenance.domain.mapper.VehicleMapper;
import com.trigerz.vehicle.maintenance.domain.model.OwnerModel;
import com.trigerz.vehicle.maintenance.persistence.repository.OwnerRepository;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import com.trigerz.vehicle.maintenance.rest.dto.OwnerDtoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OwnerDaoService ownerDaoService(OwnerRepository ownerRepository, OwnerMapper ownerMapper, JpaOwnerMapper jpaMapper) {
        return new OwnerDaoService(ownerRepository, ownerMapper, jpaMapper);
    }

    @Bean
    public VehicleDaoService vehicleDaoService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, JpaVehicleMapper jpaMapper) {
        return new VehicleDaoService(vehicleRepository, vehicleMapper, jpaMapper);
    }

    @Bean
    public OwnerDtoService ownerDtoService(DaoServiceInterface<OwnerModel> ownerDaoService, OwnerMapper ownerMapper) {
        return new OwnerDtoService(ownerDaoService, ownerMapper);
    }
}
