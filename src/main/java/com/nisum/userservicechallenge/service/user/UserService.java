package com.nisum.userservicechallenge.service.user;

import com.nisum.userservicechallenge.web.payload.request.SignUpRequest;
import com.nisum.userservicechallenge.web.payload.response.SignUpResponse;

/** Contrato que contiene todas las operaciones del servicio de usuario */
public interface UserService {

  SignUpResponse createUser(SignUpRequest signUpRequest);
}
