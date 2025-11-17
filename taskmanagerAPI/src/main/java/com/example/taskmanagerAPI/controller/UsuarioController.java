package com.example.taskmanagerAPI.controller;

import com.example.taskmanagerAPI.dto.UsuarioRequestDTO;
import com.example.taskmanagerAPI.dto.UsuarioResponseDTO;
import com.example.taskmanagerAPI.service.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(
            usuarioService.listarUsuario()
        );
    }

    @GetMapping("/buscar")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuario(@RequestParam("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String, Object>> salvarUsuario(
        @Valid @RequestBody UsuarioRequestDTO usuario
    ) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(
            Map.of("mensagem", "Usuario salvo.", "sucesso", true)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarUsuario(
        @PathVariable("id") Long id,
        @Valid @RequestBody UsuarioRequestDTO usuario
    ) {
        usuarioService.atualizarUsuario(id, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(
            Map.of("mensagem", "Usuário atualizado.", "sucesso", true)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarUsuario(
        @PathVariable("id") Long id
    ) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.OK).body(
            Map.of("mensagem", "Usuário deletado.", "sucesso", true)
        );
    }
}
