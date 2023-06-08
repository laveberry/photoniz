package com.laveberry.photoniz.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class FileUploader {

    @Value("${upload.path}")
    private String path;

    private final String DELIMITER = File.separator;

    public void upload(String fileName, MultipartFile file) {
        final String fileFullPath = path + DELIMITER + fileName;
        System.out.println("fileFullPath = " + fileFullPath);
    }
}
