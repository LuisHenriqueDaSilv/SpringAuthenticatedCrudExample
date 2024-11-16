package com.luissilva.example.DbServices;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luissilva.example.Models.UserModel;
import com.luissilva.example.repositories.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersServices {

  private final UserRepository userRepository;

  @Transactional
  public void save(UserModel user){
    user.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
    userRepository.save(user);
  }  

  public Optional<UserModel> findByName(String username){
    return userRepository.findByName(username);
  }
}
