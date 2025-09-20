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


    public void deletar (UUID id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }

    public Cliente atualizar(UUID id, Cliente cliente){
        if(clienteRepository.existsById(id)){
           return clienteRepository.save(cliente);
        }else {
            throw new RuntimeException("Usuário não encontrado.");
        }
    }
}
