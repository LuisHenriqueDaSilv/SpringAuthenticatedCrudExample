package com.luissilva.example.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequestDTO {
  @Size(max=20, min=4)
  @NotBlank
  String name;
  @NotBlank
  String password;
}
