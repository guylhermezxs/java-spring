package com.example.javaspring_exercicio.model;


import jakarta.persistence.*;

@Entity
@Table(name = "tab_endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnidadeFederativa uf;

    public EnderecoModel() {
    }

    public EnderecoModel(Long id, String cep, String logradouro, String cidade, UnidadeFederativa uf) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UnidadeFederativa getUf() {
        return uf;
    }

    public void setUf(UnidadeFederativa uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", uf=" + uf.getSigla() +
                '}';
    }
}
