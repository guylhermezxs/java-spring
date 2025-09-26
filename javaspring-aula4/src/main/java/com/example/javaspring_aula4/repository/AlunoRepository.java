package com.example.javaspring_aula4.repository;

import com.example.javaspring_aula4.model.Aluno;
import com.example.javaspring_aula4.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno , UUID> {
    Optional<Aluno> findByEmail(String email);
    List<Aluno> findByNome(String nome);
}
