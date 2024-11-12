package Aplicativo_de_Notas_e_Media;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppNotas {
    private JPanel panelAppNotas;
    private JPanel panelInferior;
    private JPanel panelSuperior;
    private JPanel panelSupDireito;
    private JPanel panelSupEsquerdo;
    private JButton bntCalcMedia;
    private JButton btnAddNota;
    private JTextField txtfAddNotas;
    private JLabel jlbAprovacao;
    private JLabel jlbMedia;
    private JTextArea txtAreaDeNotas;
    private JButton btnLimpar;
    private String notaDoAluno;
    private int contador = 1;
    private String notaMedia;

    CalculadoraDeMedia cal = new CalculadoraDeMedia();

    public AppNotas() {
        btnAddNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                notaDoAluno = txtfAddNotas.getText();

                if (notaDoAluno.equals("")) {
                    txtfAddNotas.setText("");
                }else {

                    if (txtAreaDeNotas.getText().equals("")) {
                        txtAreaDeNotas.setText("Nota " + contador + " = " + notaDoAluno );
                        contador++;
                        cal.salvarNota(notaDoAluno);
                    }else {
                        txtAreaDeNotas.setText(txtAreaDeNotas.getText()+"\n"+"Nota " + contador + " = " + notaDoAluno);
                        contador++;
                        cal.salvarNota(notaDoAluno);
                    }



                }

            }
        });


        bntCalcMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                notaMedia = cal.mediaNota(contador);

                jlbMedia.setText(notaMedia);

                if (Double.valueOf(notaMedia) >= 6) {
                    jlbAprovacao.setText("Aprovado");
                }else if (Double.valueOf(notaMedia) < 6) {
                    jlbAprovacao.setText("Reprovado");
                }

            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtfAddNotas.setText("");
                txtAreaDeNotas.setText("");
                jlbMedia.setText("");
                jlbAprovacao.setText("");
                contador = 1;
                cal.limpar();

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AppNotas");
        frame.setContentPane(new AppNotas().panelAppNotas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

}
