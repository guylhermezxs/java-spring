package com.example.javaspring_aula10.service;

import com.example.javaspring_aula10.dto.ProdutoRequestDTO;
import com.example.javaspring_aula10.dto.ProdutoResponseDTO;
import com.example.javaspring_aula10.model.ProdutoModel;
import com.example.javaspring_aula10.repository.ProdutoRepository;

import java.util.List;

public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

   public List<ProdutoResponseDTO> listarProduto(){
        return produtoRepository
                .findAll()
                .stream()
                .map(produtoModel -> new ProdutoResponseDTO(produtoModel.getNome() , produtoModel.getLote() , produtoModel.getValidade(), produtoModel.getCategoria(), produtoModel.getQuantidade()))
                .toList();
    }

    public ProdutoModel salvarProduto(ProdutoRequestDTO produto){
        if(produtoRepository.findByLote(produto.getLote()).isPresent()){
            throw new IllegalArgumentException("Produto já cadastrado.");
        }
        ProdutoModel novoProduto = new ProdutoModel();
        novoProduto.setNome(produto.getNome());
        novoProduto.setLote(produto.getLote());
        novoProduto.setValidade(produto.getValidade());
        novoProduto.setCategoria(produto.getCategoria());
        novoProduto.setQuantidade(produto.getQuantidade());
        produtoRepository.save(novoProduto);
        return novoProduto;
    }

    public ProdutoModel atualizarProduto(Long id , ProdutoRequestDTO produto){
        if (produtoRepository.existsById(id)){
            ProdutoModel atualizarProduto = new ProdutoModel();
            atualizarProduto.setId(id);
            atualizarProduto.setNome(produto.getNome());
            atualizarProduto.setLote(produto.getLote());
            atualizarProduto.setValidade(produto.getValidade());
            atualizarProduto.setCategoria(produto.getCategoria());
            atualizarProduto.setQuantidade(produto.getQuantidade());
            return produtoRepository.save(atualizarProduto);
        } else {
            throw new RuntimeException("Produto não encontrado.");
        }
    }

    public void deletarProduto(Long id){
        if (produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado.");
        }
    }
}
