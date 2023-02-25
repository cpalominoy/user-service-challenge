package com.nisum.userservicechallenge.config.jpa;

import com.nisum.userservicechallenge.persistence.domain.base.ApplicationAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {

  @Bean
  public AuditorAware<String> auditorAware() {
    return new ApplicationAuditorAware();
  }
}
