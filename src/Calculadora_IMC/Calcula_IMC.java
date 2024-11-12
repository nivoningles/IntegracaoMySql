package Calculadora_IMC;

import java.util.Locale;

public class Calcula_IMC {

    public Double imc;

    public Double calcularIMC(Double peso, Double altura) {

        imc = peso / (altura * altura);

        return imc;
    }

}
