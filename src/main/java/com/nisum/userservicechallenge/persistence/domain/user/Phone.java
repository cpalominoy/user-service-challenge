package com.nisum.userservicechallenge.persistence.domain.user;

import com.nisum.userservicechallenge.persistence.domain.base.BaseAudit;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "phones")
@Entity
public class Phone extends BaseAudit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "number", nullable = false)
  private String number;

  @Column(name = "city_code", nullable = false)
  private String cityCode;

  @Column(name = "country_code")
  private String countryCode;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
