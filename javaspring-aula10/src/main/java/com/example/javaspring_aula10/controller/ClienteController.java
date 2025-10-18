package com.example.javaspring_aula10.controller;

import com.example.javaspring_aula10.dto.ClienteRequestDTO;
import com.example.javaspring_aula10.dto.ClienteResponseDTO;
import com.example.javaspring_aula10.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ClienteResponseDTO>> listarUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listarCliente());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String , Object>> salvarCliente(@Valid @RequestBody ClienteRequestDTO cliente){
        clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem" , "Cliente salvo.", "sucesso" , true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String , Object>> atualizarCliente(@PathVariable ("id") Long id , @Valid @RequestBody ClienteRequestDTO cliente){
        clienteService.atualizarCliente(id , cliente);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Cliente atualizado.", "sucesso" , true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String , Object>> deletarCliente(@PathVariable ("id") Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Cliente deletado." , "sucesso" , true));
    }
}
