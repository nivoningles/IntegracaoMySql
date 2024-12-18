package Cadastro_De_Contatos;

import Conexoes.ConexaoContatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastroContatos extends JFrame {
    private JPanel panelInferior;
    public JPanel panelTelaContatos;
    private JPanel panelSuperior;
    private JPanel panelSupEsquerdo;
    private JPanel panelSupDireito;
    private JTextField txtfNome;
    private JTextField txtfTelefone;
    private JTextField txtfEmail;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JList<String> listContatos;
    private String nomeContato;
    private String telefoneContato;
    private String emailContato;
    private DefaultListModel<String> listModel;
    private ControleDeContatos controle;
    private List<String> nomesContatos;
    List<String> telefonesContatos;
    List<String> emailsContatos;

    public TelaCadastroContatos() {

        controle = new ControleDeContatos();
        controle.atualizarLista();
        listModel = new DefaultListModel<>();
        listContatos.setModel(listModel);
        atualizaTabela();

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                nomeContato = txtfNome.getText();
                telefoneContato = txtfTelefone.getText();
                emailContato = txtfEmail.getText();

                if (nomeContato.equals("") && telefoneContato.equals("") && emailContato.equals("")) {
                    txtfNome.setText("");
                    txtfTelefone.setText("");
                    txtfEmail.setText("");
                }else {

                    controle.contatos(txtfNome.getText(), txtfTelefone.getText(), txtfEmail.getText());
                    atualizaTabela();

                    txtfEmail.setText("");
                    txtfTelefone.setText("");
                    txtfNome.setText("");
                }


            }
        });
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selecindice = listContatos.getSelectedIndex();

                if (selecindice != -1) {

                    controle.removeComprimisso(selecindice);
                    atualizaTabela();

                }else {
                    JOptionPane.showMessageDialog(null, "Selecione um contato para remover.");
                }

            }
        });
    }

    public void atualizaTabela() {

        listModel.clear();

        nomesContatos = List.of(controle.getnomesContatos());
        telefonesContatos = List.of(controle.gettelefonesContatos());
        emailsContatos = List.of(controle.getemailsContatos());

        for (int i = 0; i < nomesContatos.size(); i++) {

            String linha = String.format("%-20s %-15s %-25s",
                    nomesContatos.get(i),
                    telefonesContatos.get(i),
                    emailsContatos.get(i));

            listModel.addElement(linha);
        }
    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new TelaCadastroContatos().panelTelaContatos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);

    }

}
