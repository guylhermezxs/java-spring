package com.example.taskmanagerAPI.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    PENDENTE("Pendente"),
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDA("Concluida");

    private String texto;

    Status(String texto) {
        this.texto = texto;
    }

    // Getter anotado com @JsonValue:
    // Define que, ao enviar para o JSON, será usado o texto amigável
    @JsonValue
    public String getTexto() {
        return texto;
    }

    // Método estático anotado com @JsonCreator:
    // Permite criar o enum a partir de uma string recebida no JSON
    @JsonCreator
    public static Status from(String value) {
        for (Status status : Status.values()) {
            // Compara ignorando maiúsculas/minúsculas
            if (status.texto.equalsIgnoreCase(value)) {
                return status;
            }
        }
        // Se não encontrar correspondência, lança exceção
        throw new IllegalArgumentException("Status inválido: " + value);
    }
}
