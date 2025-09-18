package com.example.javaspring_aula.model;

public enum Setor {
    RECURSOS_HUMANOS("Recursos Humanos"),
    FINANCEIRO("Financeiro"),
    OPERACOES("Operações");

    private String texto;

    Setor(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
