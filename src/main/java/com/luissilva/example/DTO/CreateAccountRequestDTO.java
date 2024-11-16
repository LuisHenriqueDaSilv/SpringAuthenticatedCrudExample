package com.luissilva.example.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequestDTO {
  
  @Size(max=20, min=4, message ="O nome de usuario de ter entre 4 e 20 caracteres")
  @NotBlank(message="Nome de usuário nao enviado")
  String name;
  @NotBlank(message="Senha não enviada")
  String password;
}
