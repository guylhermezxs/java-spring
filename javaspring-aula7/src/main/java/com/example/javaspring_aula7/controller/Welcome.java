package com.example.javaspring_aula7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Welcome {

    @GetMapping
    public String mensagem(){
        return "Bem-vindo ao sistema!";
    }
}
