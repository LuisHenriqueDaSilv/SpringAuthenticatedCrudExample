package com.luissilva.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
  
  @PostMapping("/create")
  public ResponseEntity<String> createNew(){
    return ResponseEntity.ok("aaa");
  }
}
