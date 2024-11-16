package com.luissilva.example.controllers;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luissilva.example.DTO.CreateAccountRequestDTO;
import com.luissilva.example.DTO.CreateAccountResponseDto;
import com.luissilva.example.DTO.ErrorResponseDTO;
import com.luissilva.example.DTO.LoginRequestDTO;
import com.luissilva.example.DbServices.UsersServices;
import com.luissilva.example.Models.UserModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  UsersServices usersServices;
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  @Autowired
  private JwtEncoder jwtEncoder;

  @PostMapping("/create")
  public ResponseEntity<Object> createAccount(@Valid @RequestBody CreateAccountRequestDTO body, Errors errors){
    Optional<UserModel> userOnDb = usersServices.findByName(body.getName());
    if(!userOnDb.isEmpty()){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDTO("Não foi possivel criar o seu perfil"));
    }

    UserModel newUser = new UserModel();
    newUser.setName(body.getName());
    String encodedPassword = passwordEncoder.encode(body.getPassword());
    newUser.setPassword(encodedPassword);
    usersServices.save(newUser);

    long expiresIn = 300l; // 300s -> 5 min
    Instant now = Instant.now();
    var jwtClaims = JwtClaimsSet.builder()
      .issuer("authenticatedCrudExample")
      .subject(newUser.getUserId().toString())
      .expiresAt(now.plusSeconds(expiresIn))
      .issuedAt(now)
      .build();

    var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaims)).getTokenValue();
    return ResponseEntity.ok(new CreateAccountResponseDto(jwtValue, expiresIn)); 
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody @Valid LoginRequestDTO body){
    Optional<UserModel> userOnDb = usersServices.findByName(body.getName());
    if(userOnDb.isEmpty()){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDTO("Nome de usuário ou senha invalidos"));
    }

    long expiresIn = 300l; // 300s -> 5 min
    Instant now = Instant.now();
    var jwtClaims = JwtClaimsSet.builder()
      .issuer("authenticatedCrudExample")
      .subject(userOnDb.get().getUserId().toString())
      .expiresAt(now.plusSeconds(expiresIn))
      .issuedAt(now)
      .build();

    var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaims)).getTokenValue();
    return ResponseEntity.ok(new CreateAccountResponseDto(jwtValue, expiresIn)); 
  }
}
