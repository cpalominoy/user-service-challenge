package com.nisum.userservicechallenge.persistence.repository;

import com.nisum.userservicechallenge.persistence.domain.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Contrato que contiene los métodos de acceso al repositorio de la entidad User (usuarios). */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * Búsqueda de usuario por email.
   *
   * @param email campo email único para la búsqueda del usuario.
   * @return objeto {@link User}.
   */
  Optional<User> findByEmail(String email);
}
