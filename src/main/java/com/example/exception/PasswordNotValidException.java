package com.example.exception;

public class PasswordNotValidException extends RuntimeException {

  private static final String PASSWORD_NOT_VALID = "Password is not valid";

  public PasswordNotValidException() {
    super(PASSWORD_NOT_VALID);
  }

}
