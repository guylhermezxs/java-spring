package com.example.javaspring_aula10.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProdutoRequestDTO {
    @NotBlank(message = "O nome é obrigatorio")
    @Size(min = 3 , message = "O nome deve ter no minino 3 caracteres.")
    private String nome;

    @NotBlank(message = "O lote é obrigatorio")
    private String lote;

    @NotBlank(message = "A validade é obrigatoria")
    private String validade;

    @NotBlank(message = "A categoria é obrigatoria")
    private String categoria;

    @NotBlank(message = "A quantidade é obrigatoria")
    @Size(min = 1)
    private int quantidade;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, String lote, String validade, String categoria, int quantidade) {
        this.nome = nome;
        this.lote = lote;
        this.validade = validade;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public @NotBlank(message = "O nome é obrigatorio") @Size(min = 3, message = "O nome deve ter no minino 3 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatorio") @Size(min = 3, message = "O nome deve ter no minino 3 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O lote é obrigatorio") String getLote() {
        return lote;
    }

    public void setLote(@NotBlank(message = "O lote é obrigatorio") String lote) {
        this.lote = lote;
    }

    public @NotBlank(message = "A validade é obrigatoria") String getValidade() {
        return validade;
    }

    public void setValidade(@NotBlank(message = "A validade é obrigatoria") String validade) {
        this.validade = validade;
    }

    public @NotBlank(message = "A categoria é obrigatoria") String getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotBlank(message = "A categoria é obrigatoria") String categoria) {
        this.categoria = categoria;
    }

    @NotBlank(message = "A quantidade é obrigatoria")
    @Size(min = 1)
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotBlank(message = "A quantidade é obrigatoria") @Size(min = 1) int quantidade) {
        this.quantidade = quantidade;
    }
}
