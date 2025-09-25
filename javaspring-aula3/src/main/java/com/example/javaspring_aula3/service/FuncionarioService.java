package com.example.javaspring_aula3.service;

import com.example.javaspring_aula3.model.Funcionario;
import com.example.javaspring_aula3.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;



@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> lista(){
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario){

        if(funcionarioRepository.findByCpf(funcionario.getCpf()).isPresent()){
            throw new RuntimeException("Funcionario já cadastrado.");
        }
       return funcionarioRepository.save(funcionario);
    }

    public void deletar(UUID id){
        if(funcionarioRepository.existsById(id)){
            funcionarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Funcionario não encontrado!");
        }
    }

    public Funcionario atualizar(UUID id , Funcionario funcionario){
        if (funcionarioRepository.existsById(id)){
            return funcionarioRepository.save(funcionario);
        } else {
            throw new RuntimeException("Funcionario não encontrado!");
        }
    }

}
