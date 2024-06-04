package com.example.repository;

import com.example.model.MedicalRecord;
import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

  @Query("SELECT m FROM MedicalRecord m WHERE m.user = :user AND m.measurementTime BETWEEN :startDate AND :endDate")
  List<MedicalRecord> findByUserAndDate(
      @Param("user") User user,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
  );

}
