package com.example.javaspring_aula10.repository;

import com.example.javaspring_aula10.model.ClienteModel;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel , Long> {
    Optional<ClienteModel> findByEmail(String email);
}
