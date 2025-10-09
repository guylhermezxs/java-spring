package com.example.javaspring_exercicio.controller;

import com.example.javaspring_exercicio.model.FuncionarioModel;
import com.example.javaspring_exercicio.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Map<String , Object>> salvarFuncionario(@RequestBody FuncionarioModel funcionario){
        funcionarioService.salvarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem" , "Funcionário salvo.", "sucesso" , true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String , Object>> deletarFuncionario(@PathVariable ("id") Long id){
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Funcionário deletado." , "sucesso" , true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String , Object>> atualizarFuncionario(@PathVariable ("id") Long id , @RequestBody FuncionarioModel funcionario){
        funcionarioService.atualizarFuncionario(id,funcionario);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Funcionário atualizado." , "sucesso" , true));
    }

    @GetMapping("/buscar")
    public List<FuncionarioModel> buscarFuncionarioMatricula(@RequestParam ("matricula") String matricula){
        return funcionarioService.buscarFuncionarioMatricula(matricula);
    }
}
