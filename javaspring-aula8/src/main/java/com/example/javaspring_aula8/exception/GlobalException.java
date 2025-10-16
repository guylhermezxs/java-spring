package com.example.javaspring_aula8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    // Padronizando mensagem de exceção do Service
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String , Object>> illegalArgumentException(IllegalArgumentException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem" , erro.getMessage(), "sucesso" , false));
    }
    // Padronizando mensagem de exceção de validação do RequestDTO
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String , Object>> methodArgumentNotValidException(MethodArgumentNotValidException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem" , erro.getFieldErrors().get(0).getDefaultMessage(), "sucesso" , false));
    }
}
