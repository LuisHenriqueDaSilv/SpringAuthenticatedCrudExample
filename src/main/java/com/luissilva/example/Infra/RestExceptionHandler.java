package com.luissilva.example.Infra;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  // @ExceptionHandler(HttpMessageNotReadableException.class)
  @Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
    HttpMessageNotReadableException ex, 
    HttpHeaders headers, 
    HttpStatusCode status, 
    WebRequest request
  ) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo da requisição invalido");
  }

}
