package com.nisum.userservicechallenge.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class ApiWebSecurityConfig {

  private static final String[] OPS_RESOURCES = {
    "/swagger-resources/**", "/swagger-ui/**", "/api-docs/**", "/actuator/**", "/users"
  };

  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests()
        .requestMatchers(OPS_RESOURCES)
        .permitAll()
        .requestMatchers(PathRequest.toH2Console())
        .permitAll()
        .anyRequest()
        .authenticated();
    http.csrf(AbstractHttpConfigurer::disable);
    http.headers((headers) -> headers.frameOptions().sameOrigin());

    return http.build();
  }
}
