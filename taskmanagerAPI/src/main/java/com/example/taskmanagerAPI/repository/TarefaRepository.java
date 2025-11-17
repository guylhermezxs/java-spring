package com.example.taskmanagerAPI.repository;

import com.example.taskmanagerAPI.model.TarefaModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
    Optional<TarefaModel> findByTitulo(String titulo);
}
