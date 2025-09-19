package com.example.javaspring_aula2.repository;

import com.example.javaspring_aula2.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente , UUID> {

}
