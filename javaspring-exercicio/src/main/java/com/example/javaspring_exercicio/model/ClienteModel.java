package com.example.javaspring_exercicio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false , unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoModel endereco;

    public ClienteModel() {
    }

    public ClienteModel(Long id, String nome, String email, EnderecoModel endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
