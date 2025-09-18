package com.example.javaspring_aula.model;

public enum Setor {
    ENGENHARIA("Engenharia"),
    SAUDE("Saúde"),
    JURIDICO("Juridico");

    private String nomeSetor;

    Setor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }
}
