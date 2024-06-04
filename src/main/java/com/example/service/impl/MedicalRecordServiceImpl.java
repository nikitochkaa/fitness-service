package com.example.service.impl;

import com.example.exception.PasswordNotValidException;
import com.example.exception.UserNotExistException;
import com.example.model.User;
import com.example.payload.response.MedicalRecordResponse;
import com.example.repository.MedicalRecordRepository;
import com.example.repository.UserRepository;
import com.example.service.MedicalRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

  private final UserRepository userRepository;
  private final MedicalRecordRepository medicalRecordRepository;

  public MedicalRecordServiceImpl(UserRepository userRepository, MedicalRecordRepository medicalRecordRepository) {
    this.userRepository = userRepository;
    this.medicalRecordRepository = medicalRecordRepository;
  }

  @Override
  public List<MedicalRecordResponse> getUserMedicalRecords(String username, String password, LocalDate date) {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UserNotExistException(username);
    }
    if (!user.getPassword().equals(password)) {
      throw new PasswordNotValidException();
    }
    LocalDateTime startOfDay = date.atStartOfDay();
    LocalDateTime endOfDay = date.atTime(LocalTime.MAX);

    return medicalRecordRepository.findByUserAndDate(user, startOfDay, endOfDay).stream()
        .map(medicalRecord -> {
          MedicalRecordResponse response = new MedicalRecordResponse();
          response.setHeartRate(medicalRecord.getHeartRate());
          response.setOxygenSaturation(medicalRecord.getOxygenSaturation());
          response.setMeasurementTime(medicalRecord.getMeasurementTime());
          return response;
        })
        .collect(Collectors.toList());
  }

}
