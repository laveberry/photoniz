package com.laveberry.photoniz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "포토니즈 API 명세서",
        description = "작가, 모델, 사용자 매칭 서비스",
        version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi photoNizApi() {
        String[] paths = {"/v1/**"};

        return GroupedOpenApi.builder()
                .group("포토니즈 API V1")
                .pathsToMatch(paths)
                .build();
    }
}
