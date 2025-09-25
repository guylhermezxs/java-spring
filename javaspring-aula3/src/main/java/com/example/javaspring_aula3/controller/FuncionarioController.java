package com.example.javaspring_aula3.controller;


import com.example.javaspring_aula3.model.Funcionario;
import com.example.javaspring_aula3.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;

    }

    @GetMapping("/listar")
    public List<Funcionario> listar(){
        return funcionarioService.lista();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario){
       funcionarioService.salvar(funcionario);
       return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable ("id") UUID id){
        funcionarioService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable ("id") UUID id , @RequestBody Funcionario funcionario){
        Funcionario funcionarioAtulizado = funcionarioService.atualizar(id,funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioAtulizado);
    }

}
