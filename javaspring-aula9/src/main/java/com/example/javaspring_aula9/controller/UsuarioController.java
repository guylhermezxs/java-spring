package com.example.javaspring_aula9.controller;

import com.example.javaspring_aula9.dto.UsuarioRequestDTO;
import com.example.javaspring_aula9.dto.UsuarioResponseDTO;
import com.example.javaspring_aula9.service.UsuarioService;
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

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarUsuario());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String , Object>> salvarUsuario(@RequestBody UsuarioRequestDTO usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem" , "Usuário salvo", "sucesso" , true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String , Object>> atualizarUsuario(@PathVariable ("id") Long id , @RequestBody UsuarioRequestDTO usuario){
        usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Usuário atualizado", "sucesso" , true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String , Object>> deletarUsuario(@PathVariable ("id") Long id){
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Map.of("mensagem", "Usuário deletado", "sucesso", true));
    }
}
