package com.example.spring_practice.controller;

import com.example.spring_practice.model.Produto;
import com.example.spring_practice.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/lista")
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Produto> salvar (@RequestBody  Produto produto){
        System.out.println("Produto recebido: " + produto);
        // Criar um identificador universalmente único.
        String id = UUID.randomUUID().toString();
        // Chamar o setter para setar o id.
        produto.setId(id);
        produtoRepository.save(produto);
        // Se o produto for salvo, retorna-o com status 200 OK
        return ResponseEntity.status(HttpStatus.OK).body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterPorId(@PathVariable("id") String id){
        return ResponseEntity.of(produtoRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable("id") String id , @RequestBody Produto produto){
        System.out.println("Produto atualizado: " + produto);
        produto.setId(id);
        produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
       return produtoRepository.findByNome(nome);
    }



}
