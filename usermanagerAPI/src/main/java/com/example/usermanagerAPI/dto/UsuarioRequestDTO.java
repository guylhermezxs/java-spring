package com.example.usermanagerAPI.dto;

import com.example.usermanagerAPI.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {
    @NotBlank(message = "O nome é obrigatorio.")
    @Size(min = 3 , max = 50 , message = "O nome deve ter o minimo de 3 caracteres.")
    private String nome;

    @NotBlank(message = "O email é obrigatorio.")
    @Email(message = "Informe um email valido.")
    private String email;

    @NotBlank(message = "A senha é obrigatorio.")
    @Size(min = 3 , max = 10 , message = "A senha deve ter entre 3 a 10 caracteres.")
    private String senha;

    @NotNull(message = "O role é obrigatorio.")
    private Role role;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email, String senha, Role role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public @NotBlank(message = "O nome é obrigatorio.") @Size(min = 3, max = 50, message = "O nome deve ter o minimo de 3 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatorio.") @Size(min = 3, max = 50, message = "O nome deve ter o minimo de 3 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O email é obrigatorio.") @Email(message = "Informe um email valido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatorio.") @Email(message = "Informe um email valido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatorio.") @Size(min = 3, max = 10, message = "A senha deve ter entre 3 a 10 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatorio.") @Size(min = 3, max = 10, message = "A senha deve ter entre 3 a 10 caracteres.") String senha) {
        this.senha = senha;
    }

    public @NotNull(message = "O role é obrigatorio.") Role getRole() {
        return role;
    }

    public void setRole(@NotNull(message = "O role é obrigatorio.") Role role) {
        this.role = role;
    }
}
