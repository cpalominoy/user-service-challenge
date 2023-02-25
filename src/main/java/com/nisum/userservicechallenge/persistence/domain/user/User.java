package com.nisum.userservicechallenge.persistence.domain.user;

import com.nisum.userservicechallenge.persistence.domain.base.BaseAudit;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

/** El modelo User (usuarios) para el servicio. */
@Getter
@Setter
@Table(name = "users")
@Entity
public class User extends BaseAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code", unique = true, nullable = false)
  private String code;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "token")
  private String token;

  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @Column(name = "is_active")
  private boolean active;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<Phone> phones;

  @PrePersist
  private void onCreate() {
    if (Objects.isNull(getCode())) {
      setCode(UUID.randomUUID().toString());
    }

    if (Objects.nonNull(getCreatedAt())) {
      setLastLogin(getCreatedAt());
    }
  }
}
