package com.example.javaspring_exercicio.repository;

import com.example.javaspring_exercicio.model.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel , Long> {

}
