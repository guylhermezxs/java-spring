package com.example.javaspring_aula10.repository;

import com.example.javaspring_aula10.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel , Long> {
    Optional<ProdutoModel> findByLote(String lote);
}
