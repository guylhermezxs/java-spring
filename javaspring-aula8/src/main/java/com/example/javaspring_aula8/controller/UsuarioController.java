package com.example.javaspring_aula8.controller;

import com.example.javaspring_aula8.dto.UsuarioRequestDTO;
import com.example.javaspring_aula8.dto.UsuarioResponseDTO;
import com.example.javaspring_aula8.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvarUsuario(@Valid @RequestBody UsuarioRequestDTO dto){
        usuarioService.salvarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Usuário cadastrado com sucesso", "sucesso", true));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarUsuario());
    }
}
