package com.example.project_modelo.montadora.configuration;

import com.example.project_modelo.montadora.Motor;
import com.example.project_modelo.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfigurantion {

    @Primary
    @Bean(name = "motorAspirado")
    public Motor motorAspirado(){
        Motor motor = new Motor();
        motor.setCavalo(120);
        motor.setCilindro(4);
        motor.setModelo("Honda Aspirado");
        motor.setTipoMotor(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        Motor motor = new Motor();
        motor.setCavalo(110);
        motor.setCilindro(4);
        motor.setModelo("Honda Eletrico");
        motor.setTipoMotor(TipoMotor.ELETRICO);
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        Motor motor = new Motor();
        motor.setCavalo(180);
        motor.setCilindro(4);
        motor.setModelo("Honda Turbo");
        motor.setLitragem(2.0);
        motor.setTipoMotor(TipoMotor.TURBO);
        return motor;
    }


}
