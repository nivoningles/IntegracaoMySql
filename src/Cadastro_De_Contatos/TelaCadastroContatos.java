package Cadastro_De_Contatos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class TelaCadastroContatos {
    private JPanel panelInferior;
    private JPanel panelTelaContatos;
    private JPanel panelSuperior;
    private JPanel panelSupEsquerdo;
    private JPanel panelSupDireito;
    private JTextField txtfNome;
    private JTextField txtfTelefone;
    private JTextField txtfEmail;
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JTable tbContatos;
    private int contador = 0;

    public TelaCadastroContatos() {

        ControleDeContatos controle = new ControleDeContatos();

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                controle.contatos(txtfNome.getText(), txtfTelefone.getText(), txtfEmail.getText());

                DefaultTableModel model = (DefaultTableModel) tbContatos.getModel();

                if (model.getColumnCount() == 0) {
                    model.setColumnIdentifiers(new String[]{"Nome", "Telefone", "Email"});
                }

                model.addRow(new Object[]{controle.getNome(contador), controle.getTelefone(contador), controle.getEmail(contador)});


                contador++;

                txtfEmail.setText("");
                txtfTelefone.setText("");
                txtfNome.setText("");


            }
        });
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) tbContatos.getModel();

                int selectedRow = tbContatos.getSelectedRow();

                if (selectedRow != -1) {

                    String nome = (String) tbContatos.getModel().getValueAt(selectedRow, 0);
                    String telefone = (String) tbContatos.getModel().getValueAt(selectedRow, 1);
                    String email = (String) tbContatos.getModel().getValueAt(selectedRow, 2);

                    model.removeRow(selectedRow);

                }

            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new TelaCadastroContatos().panelTelaContatos);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);

    }
}
