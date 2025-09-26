package com.example.javaspring_aula4.controller;

import com.example.javaspring_aula4.model.Aluno;
import com.example.javaspring_aula4.model.Cliente;
import com.example.javaspring_aula4.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/listar")
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){
        alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable ("id") UUID id){
        alunoService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable ("id") UUID id , @RequestBody Aluno aluno){
        Aluno alunoAtualizado = alunoService.atualizar(id,aluno);
        return ResponseEntity.status(HttpStatus.OK).body(aluno);
    }

    @GetMapping("/{nome}")
    public List<Aluno> buscar(@RequestParam ("nome") String nome){
        return alunoService.buscar(nome);
    }

}
