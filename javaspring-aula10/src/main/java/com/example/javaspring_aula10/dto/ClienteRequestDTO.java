package com.example.javaspring_aula10.dto;

import com.example.javaspring_aula10.model.FormaPagamento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ClienteRequestDTO {
    @NotBlank(message = "O nome é obrigatorio")
    @Size(min = 3 , max = 50 ,message = "O nome deve ter no minino 3 caracteres.")
    private String nome;

    @NotBlank(message = "O e-mail é obrigatorio.")
    @Email(message = "Deve ser um e-mail válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatorio")
    @Size(min = 11 , max = 11, message = "O telefone deve ter no minino 11 caracteres")
    private String telefone;

    @NotBlank(message = "A forma de pagamento é obrigatoria")
    private FormaPagamento formaPagamento;

    @NotBlank(message = "O endereço é obrigatorio")
    @Size(min = 5 , max = 50 , message = "O endereço deve ter no minino 5 caracteres")
    private String endereco;

    @NotBlank(message = "A senha é obrigatorio.")
    @Size(min = 3,max = 20, message = "A senha deve entre 3 a 20 caracteres.")
    private String senha;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String email, String telefone, FormaPagamento formaPagamento, String endereco, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.formaPagamento = formaPagamento;
        this.endereco = endereco;
        this.senha = senha;
    }

    public @NotBlank(message = "O nome é obrigatorio") @Size(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatorio") @Size(min = 3, max = 50, message = "O nome deve ter no minino 3 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O e-mail é obrigatorio.") @Email(message = "Deve ser um e-mail válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatorio.") @Email(message = "Deve ser um e-mail válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O telefone é obrigatorio") @Size(min = 11, max = 11, message = "O telefone deve ter no minino 11 caracteres") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é obrigatorio") @Size(min = 11, max = 11, message = "O telefone deve ter no minino 11 caracteres") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "A forma de pagamento é obrigatoria") FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(@NotBlank(message = "A forma de pagamento é obrigatoria") FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public @NotBlank(message = "O endereço é obrigatorio") @Size(min = 5, max = 50, message = "O endereço deve ter no minino 5 caracteres") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank(message = "O endereço é obrigatorio") @Size(min = 5, max = 50, message = "O endereço deve ter no minino 5 caracteres") String endereco) {
        this.endereco = endereco;
    }

    public @NotBlank(message = "A senha é obrigatorio.") @Size(min = 3, max = 20, message = "A senha deve entre 3 a 20 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatorio.") @Size(min = 3, max = 20, message = "A senha deve entre 3 a 20 caracteres.") String senha) {
        this.senha = senha;
    }
}
