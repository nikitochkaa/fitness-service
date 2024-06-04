package com.example.service;

import com.example.payload.response.MedicalRecordResponse;

import java.time.LocalDate;
import java.util.List;

public interface MedicalRecordService {

  List<MedicalRecordResponse> getUserMedicalRecords(String username, String password, LocalDate date);

}
