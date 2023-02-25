package com.nisum.userservicechallenge.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends BaseDto implements Serializable {

  private String code;

  private String name;

  private String email;

  private String password;

  private String token;

  private LocalDateTime lastLogin;

  private Boolean active;

  private Set<PhoneDto> phones;
}
