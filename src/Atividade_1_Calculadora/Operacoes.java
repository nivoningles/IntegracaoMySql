package Atividade_1_Calculadora;

import java.util.Locale;

public class Operacoes {

    private String ultimoNumero="0.";
    private Double ultimoNumeroMultiplicacao= 1.;
    private Double resultado;


    public String somarValores(String primeiroNumero) {

        resultado = (Double.valueOf(primeiroNumero) + Double.valueOf(ultimoNumero));

        ultimoNumero = resultado.toString();

        if(resultado == resultado.intValue()){
            return String.format(Locale.US, "%.0f", resultado);
        }else {
            return String.format(Locale.US, "%.2f", resultado);
        }

    }

    public String subtrairValores(String primeiroNumero) {

        resultado = (Double.valueOf(primeiroNumero) - Double.valueOf(ultimoNumero));

        ultimoNumero = resultado.toString();

        resultado = -resultado;

        if(resultado == resultado.intValue()){
            return String.format(Locale.US, "%.0f", resultado);
        }else {
            return String.format(Locale.US, "%.2f", resultado);
        }
    }

    public String multiplicarValores(String primeiroNumero) {

        resultado = (Double.valueOf(primeiroNumero) * ultimoNumeroMultiplicacao);

        ultimoNumero = resultado.toString();
        ultimoNumeroMultiplicacao = resultado;

        if(resultado == resultado.intValue()){
            return String.format(Locale.US, "%.0f", resultado);
        }else {
            return String.format(Locale.US, "%.2f", resultado);
        }

    }

    public String dividirValores(String primeiroNumero) {

        if (ultimoNumeroMultiplicacao == 1.) {

            resultado = Double.valueOf(primeiroNumero);
            ultimoNumero = resultado.toString();
            ultimoNumeroMultiplicacao = ultimoNumeroMultiplicacao + 1.;
            if(resultado == resultado.intValue()){
                return String.format(Locale.US, "%.0f", resultado);
            }else {
                return String.format(Locale.US, "%.2f", resultado);
            }

        }else {
                if (primeiroNumero.equals("0")){
                    return "Erro";
                }else {

                    resultado = (Double.valueOf(ultimoNumero) / Double.valueOf(primeiroNumero));
                    ultimoNumero = resultado.toString();
                    if(resultado == resultado.intValue()){
                        return String.format(Locale.US, "%.0f", resultado);
                    }else {
                        return String.format(Locale.US, "%.2f", resultado);
                    }

                }

        }

    }

    public void zerarUltimovalor(){

        ultimoNumero = "0.";
        ultimoNumeroMultiplicacao = 1.;
        resultado = 0.;

    }



}
