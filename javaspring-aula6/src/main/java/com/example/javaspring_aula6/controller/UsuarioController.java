package com.example.javaspring_aula6.controller;

import com.example.javaspring_aula6.model.UsuarioModel;
import com.example.javaspring_aula6.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public List<UsuarioModel> listarUsuarios(){
        return usuarioService.listarUsuario();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String, Object>> salvarUsuario(@RequestBody UsuarioModel usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Usuario cadastrado."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarUsuario(@PathVariable ("id")UUID id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Usuario deletado."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarUsuario(@PathVariable ("id") UUID id , @RequestBody UsuarioModel usuario){
        usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Usuario atualizado"));
    }

    @GetMapping("/buscar")
    public List<UsuarioModel> buscarNome(@RequestParam ("nome") String nome){
       return usuarioService.buscarNome(nome);
    }
}
