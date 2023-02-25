package com.nisum.userservicechallenge.web.payload.response;

import com.nisum.userservicechallenge.shared.dto.PhoneDto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class SignUpResponse {

  @Schema(
      title = "Id Público del usuario ",
      example = "7b66c584-4562-4ef3-a401-17d834580cfa",
      description = "Id público del usuario en formato UUID")
  private String id;

  @Schema(
      title = "nombre del usuario",
      example = "Juan Riquelme",
      description = "Nombre del usuario a Registrar")
  private String name;

  @Schema(
      title = "email del usuario",
      example = "juan.riquelme@gmail.com",
      description = "email del usuario único en el sistema")
  private String email;

  @Schema(description = "lista de teléfonos asociado al usuario")
  private List<PhoneDto> phones;

  @Schema(
      title = "Fecha de creación",
      example = "2022-02-25 13:22:23S",
      description = "Fecha de creación del usuario")
  private LocalDateTime created;

  @Schema(
      title = "Fecha de la ultima actualización",
      example = "2022-02-25 13:22:23S",
      description = "Fecha de la ultima actualización del usuario")
  private LocalDateTime modified;

  @Schema(
      title = "Fecha del último ingreso",
      example = "2022-02-25 13:22:23S",
      description = "Fecha del último ingreso del usuario al sistema")
  private LocalDateTime lastLogin;

  @Schema(
      title = "Token de acceso",
      example =
          "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGZyZWRvLnBhbG9taW5vQGdtYWlsLmNvbSIsImlhdCI6MTY3NzI4MDMxOCwiZXhwIjoxNjc3MzY2NzE4fQ.2crOzcRfbuICiKcFRFOZW4C8aYR0csNzWILBoY4kKrw",
      description = "Token de acceso de la API")
  private String token;

  @Schema(
      title = "Indicador de habilitado",
      example = "True|False",
      description = "Indicador si el usuario se encuentra habilitado dentro del sistema")
  private Boolean active;
}
