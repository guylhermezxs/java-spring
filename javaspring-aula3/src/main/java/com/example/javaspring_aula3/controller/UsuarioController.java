package com.example.javaspring_aula3.controller;

import com.example.javaspring_aula3.model.Cliente;
import com.example.javaspring_aula3.model.Funcionario;
import com.example.javaspring_aula3.model.Usuario;
import com.example.javaspring_aula3.service.ClienteService;
import com.example.javaspring_aula3.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public List<Usuario> listar(){
        return usuarioService.lista();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable ("id") UUID id){
        usuarioService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable ("id") UUID id , @RequestBody Usuario usuario){
        Usuario usuarioAtulizado = usuarioService.atualizar(id,usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}
