package com.example.javaspring_aula4.service;

import com.example.javaspring_aula4.model.Cliente;
import com.example.javaspring_aula4.repository.ClienteRepository;
import org.springframework.stereotype.Service;

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

        if(clienteRepository.findByEmail(cliente.getEmail()).isPresent()){
            throw new RuntimeException("Cliente já cadastrado.");
        }
        return clienteRepository.save(cliente);
    }

    public void deletar(UUID id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

    public Cliente atualizar(UUID id ,Cliente cliente){
        if (clienteRepository.existsById(id)){
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }
}
