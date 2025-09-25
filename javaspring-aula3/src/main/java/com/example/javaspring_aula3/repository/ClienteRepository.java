package com.example.javaspring_aula3.repository;

import com.example.javaspring_aula3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente , UUID> {

    Optional<Cliente> findByProtocoloAtendimento(String protocoloAtendimento);
}
