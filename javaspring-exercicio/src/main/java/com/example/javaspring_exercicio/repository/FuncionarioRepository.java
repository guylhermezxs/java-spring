package com.example.javaspring_exercicio.repository;

import com.example.javaspring_exercicio.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel , Long> {
    Optional<FuncionarioModel> findByEmail(String email);
    List<FuncionarioModel> findByMatricula(String matricula);
}
