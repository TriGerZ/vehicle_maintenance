package com.trigerz.vehicle.maintenance.storage.service;

import com.google.api.services.drive.model.File;

import java.util.List;

public interface FileService {
    File getFile(String id);
    List<File> getFiles();
    List<File> getFiles(String filter);
    void createFile(File file);
    void deleteFile(String id);
    boolean isFileExist(String id);

}
