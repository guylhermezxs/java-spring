package com.example.javaspring_aula7.service;

import com.example.javaspring_aula7.model.FuncionarioModel;
import com.example.javaspring_aula7.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioModel> listarFuncionario(){
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel salvarFuncionario(FuncionarioModel funcionarioModel){
        if(funcionarioRepository.findByEmail(funcionarioModel.getEmail()).isPresent()){
            throw new IllegalArgumentException("Funcionário já cadastrado!");
        }
        return funcionarioRepository.save(funcionarioModel);
    }

    public void deletarFuncionario(UUID id){
        if (funcionarioRepository.existsById(id)){
           funcionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Funcionário não encontrado!");
        }
    }

    public FuncionarioModel atualizarFuncionario(UUID id , FuncionarioModel funcionario){
        if(funcionarioRepository.existsById(id)){
            funcionario.setId(id);
           return funcionarioRepository.save(funcionario);
        } else {
            throw new RuntimeException("Funcionário não encontrado!");
        }
    }

    public List<FuncionarioModel> buscarFuncionario(String nome){
        return funcionarioRepository.findByNome(nome);
    }
}
