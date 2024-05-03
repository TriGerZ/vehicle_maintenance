package com.trigerz.vehicle.maintenance.storage.service;

import com.google.api.services.drive.model.File;
import com.trigerz.vehicle.maintenance.storage.client.DriveFactory;
import com.trigerz.vehicle.maintenance.storage.service.exception.FileServiceException;

import java.io.IOException;
import java.util.List;

public class FileServiceImpl implements FileService {
    private final DriveFactory driveFactory;

    public FileServiceImpl(DriveFactory driveFactory) {
        this.driveFactory = driveFactory;
    }

    @Override
    public File getFile(String id) {
        try {
            return driveFactory.getDriveService().files().get(id).execute();
        } catch (IOException e) {
            throw new FileServiceException(e);
        }
    }

    @Override
    public List<File> getFiles() {
        try {
            return driveFactory.getDriveService().files().list().execute().getFiles();
        } catch (IOException e) {
            throw new FileServiceException(e);
        }
    }

    @Override
    public List<File> getFiles(String filter) {
        return List.of();
    }

    @Override
    public void createFile(File file) {
        try {
            driveFactory.getDriveService().files().create(file).execute();
        } catch (IOException e) {
            throw new FileServiceException(e);
        }
    }

    @Override
    public void deleteFile(String id) {
        try {
            driveFactory.getDriveService().files().delete(id).execute();
        } catch (IOException e) {
            throw new FileServiceException(e);
        }
    }

    @Override
    public boolean isFileExist(String id) {
        return false;
    }
}
