package com.luissilva.example.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luissilva.example.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
  Optional<UserModel> findByName(String name);
}
