package com.example.javaspring_exercicio.repository;

import com.example.javaspring_exercicio.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel , Long> {
    Optional<ClienteModel> findByEmail(String email);
    List<ClienteModel> findByNome(String nome);
}
