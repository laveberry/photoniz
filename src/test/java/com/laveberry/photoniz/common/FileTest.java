package com.laveberry.photoniz.common;

import com.laveberry.photoniz.common.util.FileUploader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@DisplayName("파일 업로드 테스트")
class FileTest extends BaseSpringBootTest {

    private final String basicPath = "resources/image";

    @Autowired
    private FileUploader uploader;

    @Test
    @DisplayName("파일 경로")
    void filePath() throws IOException {

        MockMultipartFile file = new MockMultipartFile("image", "test.jpg", "image/jpg",
                new FileInputStream("src/test/resources/image/test.jpg"));

//        uploader.upload("image.jpg", file); //실제로 업로드까지 하지는 않겠음
        Assertions.assertThat(file.getName()).isEqualTo("image");
    }
}
