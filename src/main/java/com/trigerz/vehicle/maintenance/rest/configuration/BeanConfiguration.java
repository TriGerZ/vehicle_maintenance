package com.trigerz.vehicle.maintenance.rest.configuration;

import com.trigerz.vehicle.maintenance.persistence.repository.VehicleRepository;
import com.trigerz.vehicle.maintenance.persistence.service.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public VehicleService vehicleDaoService(VehicleRepository vehicleRepository){
        return new VehicleService(vehicleRepository);
    }
}
