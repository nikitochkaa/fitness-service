package com.example.service.impl;

import com.example.repository.UserRepository;
import com.example.exception.UserAlreadyExistsException;
import com.example.model.User;
import com.example.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;

  public AuthServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void register(String username, String password) {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    if (userRepository.existsByUsername(username)) {
      throw new UserAlreadyExistsException(username);
    }
    userRepository.save(user);
  }

}
