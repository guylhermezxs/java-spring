package com.example.javaspring_aula8.repository;

import com.example.javaspring_aula8.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel , Long> {
    Optional<UsuarioModel> findByEmail(String email);
}
