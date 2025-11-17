package com.example.usermanagerAPI.dto;

import com.example.usermanagerAPI.model.Role;

public class UsuarioResponseDTO {
    private String nome;
    private String email;
    private Role role;

    public UsuarioResponseDTO() {
    }

    public UsuarioResponseDTO(String nome, String email, Role role) {
        this.nome = nome;
        this.email = email;
        this.role = role;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
