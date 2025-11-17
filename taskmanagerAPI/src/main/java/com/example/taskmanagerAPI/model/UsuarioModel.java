package com.example.taskmanagerAPI.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tab_usuario")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false , unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean ativo;

    @OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<TarefaModel> tarefas;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String nome, String email, String senha, boolean ativo, List<TarefaModel> tarefas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.tarefas = tarefas;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<TarefaModel> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<TarefaModel> tarefas) {
        this.tarefas = tarefas;
    }
}
