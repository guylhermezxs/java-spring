package com.example.javaspring_exercicio.controller;

import com.example.javaspring_exercicio.model.ClienteModel;
import com.example.javaspring_exercicio.service.ClienteService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    public List<ClienteModel> listarCliente(){
        return clienteService.listarCliente();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String , Object>> salvarCliente(@RequestBody ClienteModel cliente){
        clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cliente salvo." , "sucesso", true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String , Object>> deletarCliente(@PathVariable ("id") Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Cliente deletado." , "sucesso" , true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String , Object>> atualizarCliente(@PathVariable ("id") Long id , @RequestBody ClienteModel cliente){
        clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Cliente atualizado." , "sucesso" , true));
    }

    @GetMapping("/buscar")
    public List<ClienteModel> buscarClienteNome(@RequestParam ("nome") String nome){
        return clienteService.buscarClienteNome(nome);
    }
}
