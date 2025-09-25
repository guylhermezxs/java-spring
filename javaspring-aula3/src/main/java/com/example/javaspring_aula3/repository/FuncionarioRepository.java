package com.example.javaspring_aula3.repository;

import com.example.javaspring_aula3.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    Optional<Funcionario> findByCpf(String cpf);
}
