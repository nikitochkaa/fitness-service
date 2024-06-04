package com.example.payload.response;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class MedicalRecordResponse {

  private Integer heartRate;
  private Integer oxygenSaturation;
  private LocalDateTime measurementTime;

}
