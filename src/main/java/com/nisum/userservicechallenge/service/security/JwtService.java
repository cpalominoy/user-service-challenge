package com.nisum.userservicechallenge.service.security;

/** Contrato para las operaciones del servicio JWT */
public interface JwtService {

  /**
   * Generador de un Jwt Token para el nombre de usuario.
   *
   * @param email correo del usuario.
   * @return el token.
   */
  String generateJwtToken(String email);
}
