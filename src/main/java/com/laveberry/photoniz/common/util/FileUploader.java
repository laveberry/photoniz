package com.laveberry.photoniz.common.util;

import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import com.laveberry.photoniz.photo.domain.Photo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class FileUploader {

    @Value("${upload.path}")
    private String basicPath;

    private final static String DELIMITER = File.separator;

    public Map<String, String> upload(String fileName, MultipartFile multipartFile) {
        String result = "";
        Map<String, String> map = new HashMap<>();
        final String fileFullName = basicPath + DELIMITER + fileName;

        try {
            Files.createDirectories(Paths.get(basicPath));
            multipartFile.transferTo(new File(fileFullName));
            result = "OK";
            map.put("path", basicPath);
            map.put("result", result);
        } catch (IOException e) {
            log.error("파일 업로드 실패 : ", e);
            throw new CustomException(ExceptionType.SIGN_IN_FAILED);
        }
        return map;
    }
}
