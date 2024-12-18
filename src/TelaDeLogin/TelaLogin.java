package TelaDeLogin;

import Conexoes.ConexaoSenhas;
import TelaInicial.TelaInicial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaLogin {
    private static JFrame frame;
    private JPanel panelLogin;
    private JPanel panelSuperior;
    private JPanel panelSupDireito;
    private JPanel panelSupEsquerdo;
    private JPanel panelInferior;
    private JTextField txtfUsuario;
    private JPasswordField txtfSenha;
    private JButton btnAcessar;

    public TelaLogin() {
        btnAcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Connection con = ConexaoSenhas.getConexao();

                    String sql = "select * from dados_senhas where usuario=? and senha=?";

                    PreparedStatement stmt = con.prepareStatement(sql);

                    stmt.setString(1, txtfUsuario.getText());
                    stmt.setString(2, new String(txtfSenha.getPassword()));

                    ResultSet rs = stmt.executeQuery();


                    if (rs.next()) {

                        TelaInicial tela = new TelaInicial();

                        tela.setContentPane(new TelaInicial().panelInicial);
                        tela.setVisible(true);
                        tela.setTitle("Tela Inicial");
                        tela.pack();
                        frame.dispose();

                    }else {
                        JOptionPane.showMessageDialog(null, "não deu certo kkk");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Tela de Login");
        frame.setContentPane(new TelaLogin().panelLogin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
