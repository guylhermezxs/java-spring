package com.example.javaspring_exercicio.model;

public enum UnidadeFederativa {
    BAHIA("Bahia"),
    SAO_PAULO("São Paulo"),
    RIO_DE_JANEIRO("Rio de Janeiro");

    private String sigla;

    UnidadeFederativa(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla() {
        return sigla;
    }
}
