package com.example.java_spring.controller;

import com.example.java_spring.model.Cliente;
import com.example.java_spring.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/lista")
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Cliente> deletar(@RequestBody Cliente cliente){
        clienteRepository.delete(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }
}
