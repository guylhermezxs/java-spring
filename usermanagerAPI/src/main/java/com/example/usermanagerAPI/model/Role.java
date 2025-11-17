package com.example.usermanagerAPI.model;

import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    USER("User"),
    ADMIN("Admin");

    private String texto;

    Role(String texto) {
        this.texto = texto;
    }
    @JsonValue
    public String getTexto() {
        return texto;
    }


    @JsonCreator
    public static Role from(String value) {
        for (Role role : Role.values()) {
            // Compara ignorando maiúsculas/minúsculas
            if (role.texto.equalsIgnoreCase(value)) {
                return role;
            }
        }
        // Se não encontrar correspondência, lança exceção
        throw new IllegalArgumentException("Status inválido: " + value);
    }

}
