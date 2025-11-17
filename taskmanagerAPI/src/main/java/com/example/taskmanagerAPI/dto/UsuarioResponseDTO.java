package com.example.taskmanagerAPI.dto;

public class UsuarioResponseDTO {
    private String nome;
    private String email;
    private boolean ativo;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(String nome, String email, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
