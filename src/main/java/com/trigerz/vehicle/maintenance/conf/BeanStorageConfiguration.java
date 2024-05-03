package com.trigerz.vehicle.maintenance.conf;

import com.trigerz.vehicle.maintenance.storage.client.DriveFactory;
import com.trigerz.vehicle.maintenance.storage.client.GoogleAPIFactory;
import com.trigerz.vehicle.maintenance.storage.service.FileService;
import com.trigerz.vehicle.maintenance.storage.service.FileServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanStorageConfiguration {
    private final ConfigProperties configProperties;

    public BeanStorageConfiguration(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @Bean
    public GoogleAPIFactory googleAPIFactory() {
        return new GoogleAPIFactory(configProperties);
    }

    @Bean
    public DriveFactory driveFactory(GoogleAPIFactory googleAPIFactory) {
        return new DriveFactory(googleAPIFactory);
    }

    @Bean
    public FileService fileService(DriveFactory driveFactory) {
        return new FileServiceImpl(driveFactory);
    }
}
