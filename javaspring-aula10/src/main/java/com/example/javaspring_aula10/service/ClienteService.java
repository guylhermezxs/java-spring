package com.example.javaspring_aula10.service;

import com.example.javaspring_aula10.dto.ClienteRequestDTO;
import com.example.javaspring_aula10.dto.ClienteResponseDTO;
import com.example.javaspring_aula10.model.ClienteModel;
import com.example.javaspring_aula10.repository.ClienteRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ClienteService(ClienteRepository clienteRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.clienteRepository = clienteRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<ClienteResponseDTO> listarCliente(){
        return clienteRepository
                .findAll()
                .stream()
                .map(clienteModel -> new ClienteResponseDTO(clienteModel.getNome() , clienteModel.getEmail() , clienteModel.getTelefone()))
                .toList();
    }

    public ClienteModel salvarCliente(ClienteRequestDTO cliente){
        if(clienteRepository.findByEmail(cliente.getEmail()).isPresent()){
            throw new IllegalArgumentException("Cliente já cadatrado.");
        }
        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(cliente.getNome());
        novoCliente.setEmail(cliente.getEmail());
        novoCliente.setTelefone(cliente.getTelefone());
        novoCliente.setFormaPagamento(cliente.getFormaPagamento());
        novoCliente.setEndereco(cliente.getEndereco());
        novoCliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
        clienteRepository.save(novoCliente);
        return novoCliente;
    }

    public ClienteModel atualizarCliente(Long id , ClienteRequestDTO cliente){
        if (clienteRepository.existsById(id)){
            ClienteModel atualizarCliente = new ClienteModel();
            atualizarCliente.setId(id);
            atualizarCliente.setNome(cliente.getNome());
            atualizarCliente.setEmail(cliente.getEmail());
            atualizarCliente.setTelefone(cliente.getTelefone());
            atualizarCliente.setFormaPagamento(cliente.getFormaPagamento());
            atualizarCliente.setEndereco(cliente.getEndereco());
            atualizarCliente.setSenha(cliente.getSenha());
            atualizarCliente.setSenha(bCryptPasswordEncoder.encode(cliente.getSenha()));
            return clienteRepository.save(atualizarCliente);
        } else {
            throw new RuntimeException("Cliente não encontrado.");
        }
    }

    public void deletarCliente(Long id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado.");
        }
    }
}
