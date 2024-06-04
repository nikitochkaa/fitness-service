package com.example.controller;

import com.example.payload.response.MedicalRecordResponse;
import com.example.service.MedicalRecordService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@Validated
public class MedicalRecordController {

  private final MedicalRecordService medicalRecordService;

  public MedicalRecordController(MedicalRecordService medicalRecordService) {
    this.medicalRecordService = medicalRecordService;
  }

  @GetMapping
  public ResponseEntity<List<MedicalRecordResponse>> getUserMedicalRecords(
      @RequestParam @NotBlank(message = "username cannot be empty") String username,
      @RequestParam @NotBlank(message = "password cannot be empty") String password,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
  ) {
    return ResponseEntity.ok(medicalRecordService.getUserMedicalRecords(username, password, date));
  }

}
