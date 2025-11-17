package com.example.taskmanagerAPI.dto;

import com.example.taskmanagerAPI.model.Status;



import java.time.LocalDateTime;

public class TarefaResponseDTO {
    private String titulo;
    private String descricao;
    private Status status;
    private LocalDateTime dataCriacao;

    public TarefaResponseDTO() {
    }

    public TarefaResponseDTO(String titulo, String descricao, Status status, LocalDateTime dataCriacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataCriacao = dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
