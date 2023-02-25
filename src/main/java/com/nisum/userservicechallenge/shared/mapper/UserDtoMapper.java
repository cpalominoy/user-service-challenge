package com.nisum.userservicechallenge.shared.mapper;

import com.nisum.userservicechallenge.persistence.domain.user.User;
import com.nisum.userservicechallenge.shared.dto.UserDto;
import com.nisum.userservicechallenge.web.payload.request.SignUpRequest;
import com.nisum.userservicechallenge.web.payload.response.SignUpResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserDtoMapper {

  /**
   * Convertir la entidad User hacia el objeto UserDto.
   *
   * @param user entidad User
   * @return objeto {@link UserDto}
   */
  UserDto toUserDto(User user);

  /**
   * Convertir el objeto UserDto a la entidad User.
   *
   * @param userDto objeto UserDto
   * @return objeto {@link User}
   */
  User toUser(UserDto userDto);

  /**
   * Convertir el objeto signUpRequest hacia el objeto {@link UserDto}.
   *
   * @param signUpRequest objeto para la creacion de usuario.
   * @return Objeto {@link UserDto}
   */
  UserDto toUserDto(SignUpRequest signUpRequest);

  /**
   * Convertir el objeto userDto hacia el objeto {@link SignUpResponse}
   *
   * @param user objeto que contiene los datos del usuario.
   * @return objeto {@link SignUpResponse}
   */
  @Mapping(target = "id", source = "code")
  @Mapping(target = "created", source = "createdAt")
  @Mapping(target = "modified", source = "updatedAt")
  SignUpResponse toSignUpResponse(User user);
}
