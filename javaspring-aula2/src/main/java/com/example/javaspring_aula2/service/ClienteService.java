package com.example.javaspring_aula2.service;

import com.example.javaspring_aula2.model.Cliente;
import com.example.javaspring_aula2.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }


    public Cliente salvar(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable("id") UUID id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") UUID id , @RequestBody Cliente cliente){
        System.out.println("Cliente atualizado: " + cliente);
        cliente.setId(id);
        clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
