package com.example.javaspring_aula7.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class FuncionarioException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String , Object>> illegalArgumentException (IllegalArgumentException erro){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("mensagem", erro.getMessage(), "sucesso", false));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String , Object>> runtimeException (RuntimeException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("mensagem" , erro.getMessage(), "sucesso" , false));
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<Map<String , Object>> emailException(EmailException erro){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("mensagem", erro.getMessage(), "sucesso" , false));
    }
}
