package com.example.javaspring_exercicio.service;

import com.example.javaspring_exercicio.exception.EmailException;
import com.example.javaspring_exercicio.model.FuncionarioModel;
import com.example.javaspring_exercicio.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioModel> listarFuncionario(){
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel salvarFuncionario(FuncionarioModel funcionario){
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()){
           return funcionarioRepository.save(funcionario);
        } else {
            throw new EmailException("Funcionário já cadastrado.");
        }
    }

    public void deletarFuncionario(Long id){
        if (funcionarioRepository.existsById(id)){
            funcionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Funcinário não encontrado.");
        }
    }

    public FuncionarioModel atualizarFuncionario(Long id , FuncionarioModel funcionario){
        if (funcionarioRepository.existsById(id)){
            funcionario.setId(id);
            return funcionarioRepository.save(funcionario);
        } else {
            throw new IllegalArgumentException("Funcionário não encontrado.");
        }
    }

    public List<FuncionarioModel> buscarFuncionarioMatricula(String matricula){
        return funcionarioRepository.findByMatricula(matricula);
    }
}
