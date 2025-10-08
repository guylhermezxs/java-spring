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

    public List<FuncionarioModel> listarFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel salvar(FuncionarioModel funcionarioModel , UUID id){
        if(funcionarioRepository.existsById(id)){

        }
    }
}
