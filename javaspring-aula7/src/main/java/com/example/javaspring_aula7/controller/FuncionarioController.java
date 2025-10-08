package com.example.javaspring_aula7.controller;

import com.example.javaspring_aula7.model.FuncionarioModel;
import com.example.javaspring_aula7.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }


    @GetMapping("/listar")
    public List<FuncionarioModel> listarFuncionario(){
        return funcionarioService.listarFuncionario();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String,Object>> salvarFuncionario(@RequestBody FuncionarioModel funcionario){
        funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem" , "Funcionário cadastrado.", "sucesso" , true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String , Object>> deletarFuncionario(@PathVariable ("id") UUID id){
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("mensagem" , "Funcionario deletado.", "sucesso" , true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String , Object>> atualizarFuncionario(@PathVariable ("id") UUID id , @RequestBody FuncionarioModel funcionario){
        funcionarioService.atualizarFuncionario(id,funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Funcionario atualizado.", "sucesso" , true));
    }

    @GetMapping("/buscar")
    public List<FuncionarioModel> buscarFuncionario(@RequestParam ("nome") String nome){
        return funcionarioService.buscarFuncionario(nome);
    }
}
