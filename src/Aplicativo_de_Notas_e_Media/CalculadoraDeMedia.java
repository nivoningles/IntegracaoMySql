package Aplicativo_de_Notas_e_Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalculadoraDeMedia {

    private Double resultadoNotas;
    private Double soma = 0.;

    public void salvarNota(String nota){

        soma = soma + Double.parseDouble(nota);

    }

    public String mediaNota (int contador){

        resultadoNotas = soma / (contador-1);

        return String.format(Locale.US,"%.2f", resultadoNotas);
    }

    public void limpar(){

        soma = 0.;

    }

}
