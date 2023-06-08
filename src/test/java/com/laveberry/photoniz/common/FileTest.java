package com.laveberry.photoniz.common;

import com.laveberry.photoniz.common.util.FileUploader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class FileTest extends BaseSpringBootTest{

    @Autowired
    private FileUploader uploader;

    @Test
    void filePath() {
        uploader.upload("image.jpg", null);
    }
}
