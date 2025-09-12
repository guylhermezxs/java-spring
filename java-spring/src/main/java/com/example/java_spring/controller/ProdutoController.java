package com.example.java_spring.controller;

import com.example.java_spring.model.Produto;
import com.example.java_spring.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/lista")
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }
}
