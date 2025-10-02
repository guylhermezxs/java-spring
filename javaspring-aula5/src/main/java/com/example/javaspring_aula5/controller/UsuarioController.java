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
    public ResponseEntity<UsuarioModel> atualizarUsuario(@PathVariable ("id") UUID id , @RequestBody UsuarioModel usuarioModel){
        usuarioService.atualizarUsuario(id,usuarioModel);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable ("id") UUID id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{nome}")
    public List<UsuarioModel> buscar(@RequestParam ("nome") String nome){
        return usuarioService.buscarNome(nome);
    }


}
