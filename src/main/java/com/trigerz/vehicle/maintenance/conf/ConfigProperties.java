package com.trigerz.vehicle.maintenance.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public record ConfigProperties(
        String googleApiKey,
        String googleClientId,
        String googleClientSecret
) {
}
