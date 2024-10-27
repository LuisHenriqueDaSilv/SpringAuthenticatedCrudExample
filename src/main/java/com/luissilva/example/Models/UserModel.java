package com.luissilva.example.Models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class UserModel implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.UUID)
  @Column(name="user_Id")
  UUID userId;

  @Column(nullable=false, unique=true)
  String name;
  @Column(nullable=false)
  String password;
  
  @Column(name="created_at")
  LocalDateTime createdAt;
}
