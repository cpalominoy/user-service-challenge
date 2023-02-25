package com.nisum.userservicechallenge.service.security.impl;

import com.nisum.userservicechallenge.service.security.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtServiceImpl implements JwtService {

  @Value("${secretKey}")
  private String secretKey;

  @Override
  public String generateJwtToken(String email) {

    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(DateUtils.addDays(new Date(), 1))
        .signWith(
            SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secretKey.getBytes()))
        .compact();
  }
}
