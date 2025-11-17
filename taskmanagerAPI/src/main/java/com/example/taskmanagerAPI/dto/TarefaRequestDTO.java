package com.example.taskmanagerAPI.dto;

import com.example.taskmanagerAPI.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TarefaRequestDTO {

    @NotBlank(message = "O titulo é obrigatorio")
    @Size(
        min = 3,
        max = 50,
        message = "O titulo deve ter no minimo 3 caracteres"
    )
    private String titulo;

    @NotBlank(message = "A descrição é obrigatorio")
    @Size(
        min = 3,
        max = 50,
        message = "A descrição deve ter minimo 3 caracteres"
    )
    private String descricao;

    @NotNull(message = "O status é obrigatorio")
    private Status status;

    @NotNull(message = "O usuário é obrigatorio")
    private Long usuarioId;

    public TarefaRequestDTO() {}

    public TarefaRequestDTO(
        String titulo,
        String descricao,
        Status status,
        Long usuarioId
    ) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.usuarioId = usuarioId;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
