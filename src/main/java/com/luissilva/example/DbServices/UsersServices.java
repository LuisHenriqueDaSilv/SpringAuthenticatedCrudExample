package com.luissilva.example.DbServices;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.stereotype.Service;

import com.luissilva.example.Models.UserModel;
import com.luissilva.example.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersServices {

  private final UserRepository userRepository;

  public void save(UserModel user){
    user.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    userRepository.save(user);
  }  
}
