package com.trigerz.vehicle.maintenance.rest.configuration;

import com.trigerz.vehicle.maintenance.persistence.repository.OwnerRepository;
import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import com.trigerz.vehicle.maintenance.persistence.service.OwnerDaoService;
import com.trigerz.vehicle.maintenance.persistence.service.VehicleDaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OwnerDaoService ownerDaoService(OwnerRepository ownerRepository){
        return new OwnerDaoService(ownerRepository);
    }

    @Bean
    public VehicleDaoService vehicleDaoService(VehicleRepository vehicleRepository){
        return new VehicleDaoService(vehicleRepository);
    }
}
