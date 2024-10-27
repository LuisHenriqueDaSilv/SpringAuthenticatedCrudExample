package com.luissilva.example.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequestDTO {
  
  @Size(max=20, min=4)
  @NotBlank
  String name;
  @NotBlank
  String password;
}
