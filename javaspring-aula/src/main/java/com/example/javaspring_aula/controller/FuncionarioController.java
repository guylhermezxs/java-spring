package com.example.javaspring_aula.controller;


import com.example.javaspring_aula.model.Funcionario;
import com.example.javaspring_aula.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class FuncionarioController {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Funcionario> salvar (@RequestBody Funcionario funcionario){
        System.out.println("Funcionario registrado: " + funcionario);
        funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @GetMapping("/listar")
    public List<Funcionario> lista(){
        return funcionarioRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") UUID id){
        if(funcionarioRepository.existsById(id)){
            funcionarioRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }






}
