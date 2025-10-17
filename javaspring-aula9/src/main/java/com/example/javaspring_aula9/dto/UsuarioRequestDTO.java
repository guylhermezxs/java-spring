package com.example.javaspring_aula9.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {
    @NotBlank(message = "O nome é obrigatorio.")
    @Size(min = 3, message = "O nome deve ter no minino 3 caracteres.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatorio.")
    @Email(message = "Deve ser um e-mail válido.")
    private String email;

    @NotBlank(message = "A senha é obrigatorio.")
    @Size(min = 3,max = 20, message = "A senha deve entre 3 a 20 caracteres.")
    private String senha;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatorio.") @Size(min = 3, message = "O nome deve ter no minino 3 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatorio.") @Size(min = 3, message = "O nome deve ter no minino 3 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O e-mail é obrigatorio.") @Email(message = "Deve ser um e-mail válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatorio.") @Email(message = "Deve ser um e-mail válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatorio.") @Size(min = 3, max = 20, message = "A senha deve entre 3 a 20 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatorio.") @Size(min = 3, max = 20, message = "A senha deve entre 3 a 20 caracteres.") String senha) {
        this.senha = senha;
    }
}
