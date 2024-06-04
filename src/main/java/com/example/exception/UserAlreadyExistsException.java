package com.example.exception;

public class UserAlreadyExistsException extends RuntimeException {

  private static final String USER_ALREADY_EXISTS = "User with username %s already exists";

  public UserAlreadyExistsException(String username) {
    super(String.format(USER_ALREADY_EXISTS, username));
  }

}
