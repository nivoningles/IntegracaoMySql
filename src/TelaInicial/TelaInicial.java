package TelaInicial;

import AgendaDiaria.LocalDeAgendamento;
import Aplicativo_de_Notas_e_Media.AppNotas;
import Atividade_1_Calculadora.Calculadora;
import Cadastro_De_Contatos.TelaCadastroContatos;
import Calculadora_IMC.Calculadora_IMC;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {
    public JPanel panelInicial;
    private JButton bntCalSimples;
    private JButton btnCalcIMC;
    private JButton btnAgenda;
    private JButton btnCadastro;
    private JButton btnMedias;
    private JPanel panelInicialInferior;
    private JPanel panelInicialSuperior;


    public TelaInicial() {
        bntCalSimples.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Calculadora calculadora = new Calculadora();

                calculadora.setTitle("Calculadora Simples");
                calculadora.setContentPane(new Calculadora().panelCalculadora);
                calculadora.setVisible(true);
                calculadora.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                calculadora.setSize(400,300);

            }
        });
        btnCalcIMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 Calculadora_IMC calculadoraIMC = new Calculadora_IMC();

                 calculadoraIMC.setTitle("Calculadora IMC");
                 calculadoraIMC.setContentPane(new Calculadora_IMC().panelDeAcesso);
                 calculadoraIMC.setVisible(true);
                 calculadoraIMC.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                 calculadoraIMC.setSize(300,300);


            }
        });
        btnAgenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LocalDeAgendamento localDeAgendamento = new LocalDeAgendamento();

                localDeAgendamento.setTitle("Agenda");
                localDeAgendamento.setContentPane(new LocalDeAgendamento().panelAgendamento);
                localDeAgendamento.setVisible(true);
                localDeAgendamento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                localDeAgendamento.pack();

            }
        });
        btnCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TelaCadastroContatos telaCadastroContatos = new TelaCadastroContatos();

                telaCadastroContatos.setTitle("Cadastro de Contatos");
                telaCadastroContatos.setContentPane(new TelaCadastroContatos().panelTelaContatos);
                telaCadastroContatos.setVisible(true);
                telaCadastroContatos.setSize(300,300);
                telaCadastroContatos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });
        btnMedias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AppNotas tela = new AppNotas();

                tela.setTitle("Calcular Média");
                tela.setContentPane(new AppNotas().panelAppNotas);
                tela.setVisible(true);
                tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                tela.setSize(300,300);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new TelaInicial();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(new TelaInicial().panelInicial);
        frame.pack();
    }
}
