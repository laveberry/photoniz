package com.laveberry.photoniz.config;

import com.laveberry.photoniz.config.jwt.CustomAccessDeniedHandler;
import com.laveberry.photoniz.config.jwt.JwtAuthenticationEntryPoint;
import com.laveberry.photoniz.config.jwt.JwtAuthenticationFilter;
import com.laveberry.photoniz.config.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
@Slf4j
@EnableMethodSecurity
public class WebConfig {

    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final CustomAccessDeniedHandler accessDeniedHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .authorizeHttpRequests(request ->
                        request.requestMatchers("/v1/user/signUp", "/v1/user/signIn",
                                        "/v1/board/list", "/v1/board/detail/**", "/swagger-ui.html").permitAll() // 이 요청은 허용 (회원가입, 로그인)
                                .anyRequest().authenticated()) // 모든 권한은 인증되어야 함
                .logout(Customizer.withDefaults()) // 로그아웃시
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), // jwt 토큰 인증 필터를 먼저 실행
                        UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
