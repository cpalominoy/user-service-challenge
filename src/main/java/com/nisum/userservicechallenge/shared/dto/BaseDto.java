package com.nisum.userservicechallenge.shared.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BaseDto {

  private Long id;
  private LocalDateTime createdAt;
  private String createdBy;
  private LocalDateTime updatedAt;
  private String updatedBy;
}
