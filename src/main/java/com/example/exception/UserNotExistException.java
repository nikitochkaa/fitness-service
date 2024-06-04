package com.example.exception;

public class UserNotExistException extends RuntimeException {

  private static final String USER_NOT_EXIST = "User with username %s do not exist";

  public UserNotExistException(String username) {
    super(String.format(USER_NOT_EXIST, username));
  }

}
