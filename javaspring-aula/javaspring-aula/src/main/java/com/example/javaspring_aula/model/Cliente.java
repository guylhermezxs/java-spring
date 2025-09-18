package com.example.javaspring_aula.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tab_cliente")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false , unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Setor setor;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;


    public Cliente() {
    }

    public Cliente(UUID id, String nome, String email, Setor setor, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.setor = setor;
        this.endereco = endereco;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", setor=" + setor +
                ", endereco=" + endereco +
                '}';
    }
}
