package com.example.javaspring_aula4.service;

import com.example.javaspring_aula4.model.Aluno;
import com.example.javaspring_aula4.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno salvar(Aluno aluno){

        if(alunoRepository.findByEmail(aluno.getEmail()).isPresent()){
            throw new RuntimeException("Cliente já cadastrado.");
        }
        return alunoRepository.save(aluno);
    }

    public void deletar(UUID id){
        if (alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

    public Aluno atualizar(UUID id , Aluno aluno){
        if (alunoRepository.existsById(id)){
            aluno.setId(id);
            return alunoRepository.save(aluno);
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

    public List<Aluno> buscar(String nome){
        return alunoRepository.findByNome(nome);
    }


}
