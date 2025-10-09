package com.example.javaspring_exercicio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false , unique = true)
    private String matricula;

    @Column(nullable = false)
    private String dataNascimento;

    @Column(nullable = false)
    private double salario;

    @Column(nullable = false , unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private EnderecoModel endereco;

    public FuncionarioModel() {
    }

    public FuncionarioModel(Long id, String nome, String matricula, String dataNascimento, double salario, String email, EnderecoModel endereco) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", salario=" + salario +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
