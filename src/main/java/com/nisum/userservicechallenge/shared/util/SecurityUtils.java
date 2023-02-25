package com.nisum.userservicechallenge.shared.util;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Esta clase de utilidad contiene operaciones personalizadas sobre la seguridad utilizada en la
 * aplicación.
 *
 * @author Stephen
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public final class SecurityUtils {

  private SecurityUtils() {
    throw new AssertionError("This class cannot be instantiated");
  }

  /**
   * Retorna TRUE si el usuario es autenticado.
   *
   * @param authentication objeto autenticación.
   * @return si el usuario esta autenticado
   */
  public static boolean isAuthenticated(Authentication authentication) {
    return Objects.nonNull(authentication)
        && authentication.isAuthenticated()
        && !(authentication instanceof AnonymousAuthenticationToken);
  }

  /**
   * Recuperar el objeto de autenticación de la sesión actual
   *
   * @return authentication
   */
  public static Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
