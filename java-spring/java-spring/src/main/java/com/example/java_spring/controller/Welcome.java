package com.example.java_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class Welcome {

        @GetMapping("/")
        public String mensagem(){
            return "Bem-vindo!";
        }

        @GetMapping("/dev")
        public String dev(){
            return "Guilherme";
        }

        @GetMapping("/java")
        public String javaspring(){
            return "java-spring";
        }

}
