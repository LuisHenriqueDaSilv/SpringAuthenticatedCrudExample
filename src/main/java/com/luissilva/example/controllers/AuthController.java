package com.luissilva.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luissilva.example.DTO.CreateAccountRequestDTO;
import com.luissilva.example.DbServices.UsersServices;
import com.luissilva.example.Models.UserModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  UsersServices usersServices;

  @PostMapping("/create")
  public ResponseEntity<Object> createAccount(@RequestBody @Valid CreateAccountRequestDTO body){
    UserModel newUser = new UserModel();
    newUser.setName(body.getName());
    newUser.setPassword(body.getPassword()); // TODO: Encrypt the password before saving it in the database
    usersServices.save(newUser);
    return ResponseEntity.ok("Created with success"); 
  }
}
