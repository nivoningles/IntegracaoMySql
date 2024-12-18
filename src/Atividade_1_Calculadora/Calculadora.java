package Atividade_1_Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame{
    public JPanel panelCalculadora;
    private JButton btn1;
    private JButton btn4;
    private JButton btn6;
    private JButton btn2;
    private JButton btn5;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn3;
    private JButton btn0;
    private JButton btnVirgula;
    private JButton btnLimpar;
    private JButton btnDividir;
    private JButton btnMultiplicar;
    private JButton btnSubtrair;
    private JButton btnResultado;
    private JButton btnSomar;
    private JPanel panelOperações;
    private JPanel panelNumeros;
    private JTextField txtfTela;
    private JPanel panelNumEOperacoes;
    private JPanel panelTela;
    private JTextField txtfJanela;
    private Integer operacao = 0;
    public String primeiroNumero;
    public String ultimoNumero;
    private String resultado;

    public Calculadora() {

        Operacoes op = new Operacoes();

        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("7");
                }else {
                    txtfTela.setText(txtfTela.getText() + "7");
                }

            }
        });

        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("8");
                }else {
                    txtfTela.setText(txtfTela.getText() + "8");
                }

            }
        });

        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("9");
                }else {
                    txtfTela.setText(txtfTela.getText() + "9");
                }

            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("4");
                }else {
                    txtfTela.setText(txtfTela.getText() + "4");
                }

            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("5");
                }else {
                    txtfTela.setText(txtfTela.getText() + "5");
                }

            }
        });

        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("6");
                }else {
                    txtfTela.setText(txtfTela.getText() + "6");
                }

            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("1");
                }else {
                    txtfTela.setText(txtfTela.getText() + "1");
                }

            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("2");
                }else {
                    txtfTela.setText(txtfTela.getText() + "2");
                }

            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("3");
                }else {
                    txtfTela.setText(txtfTela.getText() + "3");
                }

            }
        });

        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText("0");
                }else {
                    txtfTela.setText(txtfTela.getText() + "0");
                }

            }
        });

        btnVirgula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtfTela.getText().equals("")) {
                    txtfTela.setText(".");
                }else {
                    txtfTela.setText(txtfTela.getText() + ".");
                }

            }
        });


        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                primeiroNumero = txtfTela.getText();

                if (operacao.equals(1) || operacao.equals(0)) {

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.somarValores(primeiroNumero);
                        operacao = 1;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(2)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        primeiroNumero = txtfTela.getText();
                        resultado = op.subtrairValores(primeiroNumero);
                        operacao = 1;
                        txtfTela.setText("");
                    }

                }else if (operacao.equals(3)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.multiplicarValores(primeiroNumero);
                        operacao = 1;
                        txtfTela.setText("");
                    }

                }else if (operacao.equals(4)) {

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.dividirValores(primeiroNumero);
                        operacao = 1;
                        txtfTela.setText("");

                    }

                }



            }
        });

        btnSubtrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                primeiroNumero = txtfTela.getText();

                if (operacao.equals(1)) {

                    primeiroNumero = txtfTela.getText();

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.somarValores(primeiroNumero);
                        operacao = 2;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(2) || operacao.equals(0)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        primeiroNumero = txtfTela.getText();
                        resultado = op.subtrairValores(primeiroNumero);
                        operacao = 2;
                        txtfTela.setText("");
                    }

                }else if (operacao.equals(3)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.multiplicarValores(primeiroNumero);
                        operacao = 2;
                        txtfTela.setText("");
                    }

                }else if (operacao.equals(4)) {

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.dividirValores(primeiroNumero);
                        operacao = 2;
                        txtfTela.setText("");

                    }

                }

            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                primeiroNumero = txtfTela.getText();

                if (operacao.equals(1)) {

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.somarValores(primeiroNumero);
                        operacao = 3;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(2)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.subtrairValores(primeiroNumero);
                        operacao = 3;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(3) || operacao.equals(0)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.multiplicarValores(primeiroNumero);
                        operacao = 3;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(4)) {

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.dividirValores(primeiroNumero);
                        operacao = 3;
                        txtfTela.setText("");

                    }

            }
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                primeiroNumero = txtfTela.getText();


                if (operacao.equals(1)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.somarValores(primeiroNumero);
                        operacao = 1;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(2)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.subtrairValores(primeiroNumero);
                        operacao = 4;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(3)){

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.multiplicarValores(primeiroNumero);
                        operacao = 4;
                        txtfTela.setText("");

                    }

                }else if (operacao.equals(4) || operacao.equals(0)) {

                    if (primeiroNumero.equals("")) {
                        txtfTela.setText("");
                    }else {

                        resultado = op.dividirValores(primeiroNumero);
                        operacao = 4;
                        txtfTela.setText("");

                    }

                }

            }
        });

        btnResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                primeiroNumero = txtfTela.getText();

                if(primeiroNumero.equals("")){
                    txtfTela.setText(resultado);
                }else {

                if (operacao.equals(1)){

                    resultado = op.somarValores(primeiroNumero);

                    txtfTela.setText(resultado);

                    op.zerarUltimovalor();

                    operacao = 0;

                }else if (operacao.equals(2)){

                    resultado = op.subtrairValores(primeiroNumero);

                    txtfTela.setText(resultado);

                    op.zerarUltimovalor();

                    operacao = 0;

                } else if (operacao.equals(3)) {

                    resultado = op.multiplicarValores(primeiroNumero);

                    txtfTela.setText(resultado);

                    op.zerarUltimovalor();

                    operacao = 0;

                } else if (operacao.equals(4)) {

                    resultado = op.dividirValores(primeiroNumero);

                    if (resultado.equals("Erro")){
                        JOptionPane.showMessageDialog(null, "Impossível divisão por Zero");
                        txtfTela.setText("");
                    }else {

                        txtfTela.setText(resultado);

                        op.zerarUltimovalor();

                        operacao = 0;
                    }

                }

                }

            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtfTela.setText("");
                op.zerarUltimovalor();
                primeiroNumero = "";
                resultado = "";

            }
        });

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new Calculadora().panelCalculadora);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);

    }

}


