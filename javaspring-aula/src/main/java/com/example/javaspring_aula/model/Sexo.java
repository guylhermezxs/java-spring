package com.example.javaspring_aula.model;

public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String nomeSexo;

    Sexo(String nomeSexo) {
        this.nomeSexo = nomeSexo;
    }

    public String getNomeSexo() {
        return nomeSexo;
    }
}
