package com.trigerz.vehicle.maintenance.storage.client;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import com.trigerz.vehicle.maintenance.conf.ConfigProperties;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GoogleAPIFactory {

    private final ConfigProperties configProperties;

    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_FILE);
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    public GoogleAPIFactory(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    public Credential getCredentials(final NetHttpTransport netHttpTransport)
            throws IOException {

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                netHttpTransport, JSON_FACTORY, configProperties.googleClientId(), configProperties.googleClientSecret(), SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        //returns an authorized Credential object.
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
}
