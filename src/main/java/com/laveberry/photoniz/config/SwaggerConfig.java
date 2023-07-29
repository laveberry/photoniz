package com.laveberry.photoniz.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info = @Info(title = "포토니즈 API 명세서",
                description = "작가, 모델, 사용자 매칭 서비스",
                version = "v1"))
@SecurityScheme(
        name = "Authorization",
        type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi jwtApi() {
        return GroupedOpenApi.builder()
                .group("photoniz-api")
                .pathsToMatch("/**")
                .build();
    }

}