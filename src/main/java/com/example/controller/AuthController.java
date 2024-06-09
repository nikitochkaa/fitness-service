package com.example.controller;

import com.example.service.AuthService;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<Void> register(
      @RequestParam @NotBlank(message = "username cannot be empty") String username,
      @RequestParam @NotBlank(message = "password cannot be empty") String password
  ) {
    authService.register(username, password);
    return ResponseEntity.ok().build();
  }

}
