package com.example.javaspring_aula10.controller;

import com.example.javaspring_aula10.dto.ProdutoRequestDTO;
import com.example.javaspring_aula10.dto.ProdutoResponseDTO;
import com.example.javaspring_aula10.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProduto(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProduto());
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String , Object>> salvarProduto(@Valid @RequestBody ProdutoRequestDTO produto){
        produtoService.salvarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem" , "Produto salvo." , "sucesso" , true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String , Object>> atualizarProduto(@PathVariable ("id") Long id , @Valid @RequestBody ProdutoRequestDTO produto){
        produtoService.atualizarProduto(id,produto);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Produto atualizado." , "sucesso" , true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String , Object>> deletarProduto(@PathVariable ("id") Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem" , "Produto deletado." , "sucesso" , true));
    }
}
