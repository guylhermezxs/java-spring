package com.example.javaspring_aula4.repository;

import com.example.javaspring_aula4.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente , UUID> {

    Optional<Cliente> findByEmail(String email);
    List<Cliente> findByNome(String nome);
}
