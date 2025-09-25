package com.example.javaspring_aula3.service;

import com.example.javaspring_aula3.model.Cliente;
import com.example.javaspring_aula3.model.Funcionario;
import com.example.javaspring_aula3.repository.ClienteRepository;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> lista(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente){

        if(clienteRepository.findByProtocoloAtendimento(cliente.getProtocoloAtendimento()).isPresent()){
            throw new RuntimeException("Cliente já cadastrado.");
        }
        return clienteRepository.save(cliente);
    }

    public void deletar(UUID id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

    public Cliente atualizar(UUID id , Cliente cliente){
        if (clienteRepository.existsById(id)){
            return clienteRepository.save(cliente);
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

}
