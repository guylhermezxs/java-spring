package com.example.javaspring_aula6.controller;

import com.example.javaspring_aula6.model.UsuarioModel;
import com.example.javaspring_aula6.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioModel usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable ("id")UUID id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuario(@PathVariable ("id") UUID id , @RequestBody UsuarioModel usuario){
        usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping("/buscar")
    public List<UsuarioModel> buscarNome(@RequestParam ("nome") String nome){
       return usuarioService.buscarNome(nome);
    }
}
