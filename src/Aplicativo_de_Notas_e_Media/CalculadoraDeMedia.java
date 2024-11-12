package Aplicativo_de_Notas_e_Media;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CalculadoraDeMedia {

    private List<Double> salvNotas = new ArrayList<Double>();
    private Double resultadoNotas;
    private Double soma = 0.;
    private int contar = 0;

    public void salvarNota(String nota){

        salvNotas.add(Double.parseDouble(nota));
        soma = soma + salvNotas.get(contar);
        contar++;

    }

    public String mediaNota (int contador){

        resultadoNotas = soma / (contador-1);

        return String.format(Locale.US,"%.2f", resultadoNotas);
    }

    public void limpar(){

        salvNotas.clear();
        contar = 0;
        soma = 0.;

    }

}
