package com.example.project_modelo.montadora;

import java.awt.*;

public class HondaCivic extends Carro{

    public HondaCivic(Motor motor) {
        super(motor);
        setModelo("Honda Civic");
        setCor(Color.BLACK);
        setMontadora(Montadora.HONDA);
    }
}
