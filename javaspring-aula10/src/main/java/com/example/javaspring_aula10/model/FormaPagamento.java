package com.example.javaspring_aula10.model;

public enum FormaPagamento {
    CARTAO_CREDITO("Cartão de Credito"),
    CARTAO_DEBITO("Cartão de Debito"),
    PIX("Pix");

    private String texto;

    FormaPagamento(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

}
