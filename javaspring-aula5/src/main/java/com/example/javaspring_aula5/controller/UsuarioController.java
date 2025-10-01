package com.example.javaspring_aula5.controller;

import com.example.javaspring_aula5.model.UsuarioModel;
import com.example.javaspring_aula5.service.UsuarioService;
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
    public List<UsuarioModel> listarUsuario(){
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioModel usuarioModel){
        usuarioService.salvarUsuario(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizarUsuario(@PathVariable ("id")UUID id , @RequestBody UsuarioModel usuarioModel){
        UsuarioModel usuarioAtualizado = usuarioService.atualizarUsuario(id,usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModel);
    }


}
