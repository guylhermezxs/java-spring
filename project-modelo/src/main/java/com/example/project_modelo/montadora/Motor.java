package com.example.project_modelo.montadora;

public class Motor {
    private String modelo;
    private int cavalo;
    private int cilindro;
    private double litragem;
    private TipoMotor tipoMotor;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCavalo() {
        return cavalo;
    }

    public void setCavalo(int cavalo) {
        this.cavalo = cavalo;
    }

    public int getCilindro() {
        return cilindro;
    }

    public void setCilindro(int cilindro) {
        this.cilindro = cilindro;
    }

    public double getLitragem() {
        return litragem;
    }

    public void setLitragem(double litragem) {
        this.litragem = litragem;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "modelo='" + modelo + '\'' +
                ", cavalo=" + cavalo +
                ", cilindro=" + cilindro +
                ", litragem=" + litragem +
                ", tipoMotor=" + tipoMotor +
                '}';
    }
}
