package com.nisum.userservicechallenge.shared.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PhoneDto {

  @Schema(
      title = "Número telefónico",
      example = "951235748",
      description = "Número telefónico asociado al usuario")
  private String number;

  @Schema(
      title = "Código de la ciudad",
      example = "01",
      description = "Código de la ciudad del número telefónico")
  private String cityCode;

  @Schema(
      title = "Código del país",
      example = "102",
      description = "Código del país del número telefónico")
  private String countryCode;
}
