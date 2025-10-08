package com.example.javaspring_aula7.repository;

import com.example.javaspring_aula7.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, UUID> {
    Optional<FuncionarioModel> findByEmail(String email);
    List<FuncionarioModel> findByNome(String nome);
}
