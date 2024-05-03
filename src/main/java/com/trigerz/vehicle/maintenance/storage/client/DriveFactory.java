package com.trigerz.vehicle.maintenance.storage.client;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;
import com.trigerz.vehicle.maintenance.storage.client.exception.GoogleDriveFactoryException;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DriveFactory {

    private final GoogleAPIFactory googleAPIFactory;
    private static final String APPLICATION_NAME = "Vehicle_Maintenance";

    public DriveFactory(GoogleAPIFactory googleAPIFactory) {
        this.googleAPIFactory = googleAPIFactory;
    }

    public Drive getDriveService() {
        try {
            NetHttpTransport netHttpTransport = GoogleNetHttpTransport.newTrustedTransport();
            Credential credentials = null;
            credentials = googleAPIFactory.getCredentials(netHttpTransport);
            // Build a new authorized API client service.
            return new Drive.Builder(netHttpTransport, credentials.getJsonFactory(), credentials)
                    .setApplicationName(APPLICATION_NAME)
                    .build();
        } catch (GeneralSecurityException | IOException e) {
            throw new GoogleDriveFactoryException(e);
        }
    }

}
