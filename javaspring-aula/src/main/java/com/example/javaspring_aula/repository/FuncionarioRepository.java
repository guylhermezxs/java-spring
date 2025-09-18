package com.example.javaspring_aula.repository;

import com.example.javaspring_aula.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {


}
