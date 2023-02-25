package com.nisum.userservicechallenge.service.user.impl;

import com.nisum.userservicechallenge.persistence.domain.user.User;
import com.nisum.userservicechallenge.persistence.repository.UserRepository;
import com.nisum.userservicechallenge.service.security.JwtService;
import com.nisum.userservicechallenge.service.user.UserService;
import com.nisum.userservicechallenge.shared.dto.UserDto;
import com.nisum.userservicechallenge.shared.exception.UserAlreadyExistsException;
import com.nisum.userservicechallenge.shared.mapper.UserDtoMapper;
import com.nisum.userservicechallenge.web.payload.request.SignUpRequest;
import com.nisum.userservicechallenge.web.payload.response.SignUpResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  private final UserDtoMapper userDtoMapper;

  @Override
  public SignUpResponse createUser(SignUpRequest signUpRequest) {

    UserDto userDto = userDtoMapper.toUserDto(signUpRequest);

    userRepository
        .findByEmail(userDto.getEmail())
        .ifPresent(
            user -> {
              throw new UserAlreadyExistsException("El correo ya se encuentra registrado");
            });

    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userDto.setToken(jwtService.generateJwtToken(userDto.getEmail()));
    userDto.setActive(Boolean.TRUE);

    User user = userDtoMapper.toUser(userDto);
    return userDtoMapper.toSignUpResponse(userRepository.save(user));
  }
}
