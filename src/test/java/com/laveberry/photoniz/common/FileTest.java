package com.laveberry.photoniz.common;

import com.laveberry.photoniz.common.util.FileUploader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

class FileTest extends BaseSpringBootTest {

    private final String basicPath = "resources/image";

    @Autowired
    private FileUploader uploader;

    @Test
    void filePath() throws IOException {

        MockMultipartFile file = new MockMultipartFile("image", "test.jpg", "image/jpg",
                new FileInputStream("src/test/resources/image/test.jpg"));

        uploader.upload("image.jpg", file);
        Assertions.assertThat(file.getName()).isEqualTo("image");
    }
}
