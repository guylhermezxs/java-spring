package com.example.javaspring_aula6.repository;

import com.example.javaspring_aula6.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel , UUID> {

    Optional<UsuarioModel> findByEmail(String email);
    List<UsuarioModel> findByNome(String nome);
}
