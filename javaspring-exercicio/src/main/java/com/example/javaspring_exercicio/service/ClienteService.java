package com.example.javaspring_exercicio.service;

import com.example.javaspring_exercicio.exception.EmailException;
import com.example.javaspring_exercicio.model.ClienteModel;
import com.example.javaspring_exercicio.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> listarCliente(){
        return clienteRepository.findAll();
    }

    public ClienteModel salvarCliente(ClienteModel cliente){
        if(clienteRepository.findByEmail(cliente.getEmail()).isPresent()){
            throw new EmailException("Cliente já cadastrado.");
        } else {
            return clienteRepository.save(cliente);
        }
    }

    public void deletarCliente(Long id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado.");
        }
    }

    public ClienteModel atualizarCliente(Long id , ClienteModel cliente){
        if(clienteRepository.existsById(id)){
            cliente.setId(id);
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
    }

    public List<ClienteModel> buscarClienteNome(String nome){
        return clienteRepository.findByNome(nome);
    }
}
