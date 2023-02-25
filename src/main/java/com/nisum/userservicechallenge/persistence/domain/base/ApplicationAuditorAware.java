package com.nisum.userservicechallenge.persistence.domain.base;

import com.nisum.userservicechallenge.shared.util.SecurityUtils;
import java.util.Optional;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;

/**
 * Clase que obtiene el auditor actual de la aplicación, que es el correo del usuario autenticado
 */
@EqualsAndHashCode
public final class ApplicationAuditorAware implements AuditorAware<String> {
  private static final String CURRENT_AUDITOR = "system";

  /**
   * Returns the current auditor of the application.
   *
   * @return the current auditor
   */
  @NonNull
  @Override
  public Optional<String> getCurrentAuditor() {

    Authentication authentication = SecurityUtils.getAuthentication();
    if (SecurityUtils.isAuthenticated(authentication)) {
      return Optional.ofNullable(authentication.getName());
    }

    return Optional.of(CURRENT_AUDITOR);
  }
}
