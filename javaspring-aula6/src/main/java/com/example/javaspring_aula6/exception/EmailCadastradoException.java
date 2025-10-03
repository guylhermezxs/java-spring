package com.example.javaspring_aula6.exception;

public class EmailCadastradoException extends IllegalArgumentException {
    public EmailCadastradoException(String message) {
        super(message);
    }
}
