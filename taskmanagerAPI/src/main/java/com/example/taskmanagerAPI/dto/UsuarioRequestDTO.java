package com.example.taskmanagerAPI.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {
    @NotBlank(message = "O nome é obrigatorio")
    @Size(min = 3 , max = 50 ,message = "O nome deve ter minimo 3 caracteres")
    private String nome;

    @NotBlank(message = "o email é obrigatorio")
    @Email(message = "Deve ser um e-mail válido")
    private String email;

    @NotBlank(message = "A senha é obrigatorio")
    @Size(min = 3 , max = 10 , message = "A senha deve entre 3 a 10 caracteres")
    private String senha;

    @NotNull(message = "O status de ativo é obrigatorio")
    private boolean ativo;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email, String senha, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public @NotBlank(message = "O nome é obrigatorio") @Size(min = 3, max = 50, message = "O nome deve ter minimo 3 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatorio") @Size(min = 3, max = 50, message = "O nome deve ter minimo 3 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "o email é obrigatorio") @Email(message = "Deve ser um e-mail válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "o email é obrigatorio") @Email(message = "Deve ser um e-mail válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatorio") @Size(min = 3, max = 10, message = "A senha deve entre 3 a 10 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatorio") @Size(min = 3, max = 10, message = "A senha deve entre 3 a 10 caracteres") String senha) {
        this.senha = senha;
    }

    public @NotNull(message = "O status de ativo é obrigatorio") boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(@NotNull(message = "O status de ativo é obrigatorio") boolean ativo) {
        this.ativo = ativo;
    }
}
