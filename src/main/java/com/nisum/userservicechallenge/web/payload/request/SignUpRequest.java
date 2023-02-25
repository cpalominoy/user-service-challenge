package com.nisum.userservicechallenge.web.payload.request;

import com.nisum.userservicechallenge.shared.constraint.email.EmailFormatConstraint;
import com.nisum.userservicechallenge.shared.constraint.password.PasswordFormatConstraint;
import com.nisum.userservicechallenge.shared.dto.PhoneDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

/** Payload para la creación de un usuario. */
@Data
public class SignUpRequest {

  @Schema(
      title = "nombre del usuario",
      example = "Juan Riquelme",
      description = "Nombre del usuario a Registrar")
  @NotBlank(message = "Nombre del usuario es requerido")
  private String name;

  @Schema(
      title = "email del usuario",
      example = "juan.riquelme@gmail.com",
      description = "email del usuario único en el sistema")
  @NotBlank(message = "Email es requerido")
  @EmailFormatConstraint(message = "Email no cumple con el formato valido")
  private String email;

  @Schema(
      title = "contraseña del usuario",
      example = "juanRiquelme123",
      description = "contraseña del usuario")
  @NotBlank(message = "Password es requerido")
  @PasswordFormatConstraint(
      message =
          "Password debe cumplir formato (digito,minúscula,mayúscula,carácter especial y número)")
  private String password;

  @Schema(description = "lista de teléfonos asociado al usuario")
  @NotNull(message = "Teléfono es requerido")
  @NotEmpty(message = "Debe contener datos del teléfono")
  private List<PhoneDto> phones;
}
