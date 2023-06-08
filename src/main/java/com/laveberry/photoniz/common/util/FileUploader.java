package com.laveberry.photoniz.common.util;

import com.laveberry.photoniz.exception.CustomException;
import com.laveberry.photoniz.exception.ExceptionType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@Slf4j
public class FileUploader {

    @Value("${upload.path}")
    private String basicPath;

    private final String DELIMITER = File.separator;

    public void upload(String fileName, MultipartFile multipartFile) {
        final String fileFullPath = basicPath + DELIMITER + fileName;

        try {
            Files.createDirectories(Paths.get(basicPath)); //FIXME 파일경로 수정
            multipartFile.transferTo(new File(fileName));
        } catch (IOException e) {
            log.error("파일 업로드 실패 : ", e);
            throw new CustomException(ExceptionType.SIGN_IN_FAILED);
        }
    }
}
