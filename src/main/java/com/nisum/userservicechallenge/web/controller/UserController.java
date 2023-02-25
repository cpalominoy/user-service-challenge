package com.nisum.userservicechallenge.web.controller;

import com.nisum.userservicechallenge.service.user.UserService;
import com.nisum.userservicechallenge.web.payload.request.SignUpRequest;
import com.nisum.userservicechallenge.web.payload.response.SignUpResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Usuario", description = "Controlador que contiene las operaciones para los usuarios")
public class UserController {

  private final UserService userService;

  @Operation(
      summary = "Registro del usuario en el sistema.",
      description =
          "Operación para realizar el registro del usuario en el sistema, donde el correo debe ser único por usuario.",
      responses = {
        @ApiResponse(
            responseCode = "201",
            description = "Creación de usuario exitosa",
            content = @Content(schema = @Schema(implementation = SignUpResponse.class)))
      })
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  private ResponseEntity<SignUpResponse> createUser(
      @Valid @RequestBody SignUpRequest signUpRequest) {

    return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(signUpRequest));
  }
}
