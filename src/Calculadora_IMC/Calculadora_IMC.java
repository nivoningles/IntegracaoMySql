package Calculadora_IMC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Calculadora_IMC {
    private JPanel panelDeAcesso;
    private JTextField txtfPeso;
    private JTextField txtfAltura;
    private JButton btnCalcular;
    private JLabel jlIMC;
    private JLabel jlCategoria;
    private JPanel panelInferior;
    private JPanel panelInfEsquedo;
    private JPanel panelInfDireito;
    private JPanel panelSuperior;
    private JPanel panelSupEsquedo;
    private JPanel panelSupDireito;
    private Double peso;
    private Double altura;
    private String imc;

    public Calculadora_IMC() {

        Calcula_IMC calc = new Calcula_IMC();

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (txtfAltura.getText().equals("") || txtfPeso.getText().equals("")) {
                        txtfAltura.setText("");
                        txtfPeso.setText("");
                        jlIMC.setText("");
                        jlCategoria.setText("");
                    }else {

                        peso = Double.parseDouble(txtfPeso.getText());
                        altura = Double.parseDouble(txtfAltura.getText());

                    if (calc.calcularIMC(peso, altura) < 18.5){
                        imc = String.valueOf(calc.calcularIMC(peso,altura));
                        jlCategoria.setText("Baixo peso");
                        jlIMC.setText(String.format(Locale.US, "%.2f", calc.calcularIMC(peso,altura)));
                    } else if (calc.calcularIMC(peso,altura) >= 18.5 && calc.calcularIMC(peso,altura) <= 24.9) {
                        imc = String.valueOf(calc.calcularIMC(peso,altura));
                        jlCategoria.setText("Normal");
                        jlIMC.setText(String.format(Locale.US, "%.2f", calc.calcularIMC(peso,altura)));
                    } else if (calc.calcularIMC(peso,altura) >= 25 && calc.calcularIMC(peso,altura) <= 29.9) {
                        imc = String.valueOf(calc.calcularIMC(peso,altura));
                        jlCategoria.setText("Sobrepeso");
                        jlIMC.setText(String.format(Locale.US, "%.2f", calc.calcularIMC(peso,altura)));
                    }else if (calc.calcularIMC(peso,altura) >= 30) {
                        imc = String.valueOf(calc.calcularIMC(peso,altura));
                        jlCategoria.setText("Obesidade");
                        jlIMC.setText(String.format(Locale.US, "%.2f", calc.calcularIMC(peso,altura)));
                    }
                    }


                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Informe um valor valido");
                }


            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora_IMC");
        frame.setContentPane(new Calculadora_IMC().panelDeAcesso);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

}
