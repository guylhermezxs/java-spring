package com.example.javaspring_aula4.repository;

import com.example.javaspring_aula4.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco , UUID> {
}
