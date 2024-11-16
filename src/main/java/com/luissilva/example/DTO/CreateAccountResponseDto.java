package com.luissilva.example.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccountResponseDto {
  String acessToken;
  Long expiresIn;
}
