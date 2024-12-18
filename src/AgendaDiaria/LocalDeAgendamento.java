package AgendaDiaria;

import Conexoes.ConexaoAgenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class LocalDeAgendamento extends JFrame {


    private JButton btnRemoveComp;
    private JButton btnAddComp;
    private JTable tbCompromissos;
    private JTextField txtfCompromisso;
    private JSpinner jsContDias;
    private JPanel panelInferior;
    private JPanel panelSuperior;
    private JPanel panelSupEsquerdo;
    private JPanel panelSupDireito;
    public JPanel panelAgendamento;
    private JSpinner jsContAnos;
    private JSpinner jsContMes;
    private String infComprimisso;
    private String infDia;
    private String infAno;
    private String infMes;
    private int contador = 0;
    private DefaultTableModel model = (DefaultTableModel) tbCompromissos.getModel();

    public LocalDeAgendamento() {

        executNoInicio();
        SalvadorDeAgendamento salv = new SalvadorDeAgendamento();

        btnAddComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                infComprimisso = txtfCompromisso.getText();
                infDia = jsContDias.getValue().toString();
                infAno = jsContAnos.getValue().toString();
                infMes = jsContMes.getValue().toString();

                if (infComprimisso.equals("")){
                    txtfCompromisso.setText("");
                }else {

                    salv.salvador(infComprimisso, infDia, infMes, infAno);

                    atualizarTaela();

                    txtfCompromisso.setText("");

                }

            }
        });
        btnRemoveComp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int selectRow = tbCompromissos.getSelectedRow();

                if (selectRow != -1){

                    String comprimisso = (String) tbCompromissos.getModel().getValueAt(selectRow, 0);
                    String data = (String) tbCompromissos.getModel().getValueAt(selectRow, 1);
                    try {

                        Connection con = ConexaoAgenda.getConexao();

                        String sql = "DELETE FROM dados_compromisso WHERE comprimisso = ? AND data = ?";
                        PreparedStatement pst = con.prepareStatement(sql);
                        pst.setString(1, comprimisso);
                        pst.setString(2, data);

                        pst.execute();
                        pst.close();
                        con.close();

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    model.removeRow(selectRow);

                }

            }
        });
    }

    public void executNoInicio(){

        if (model.getColumnCount() == 0) {
            model.setColumnIdentifiers(new String[]{"Compromisso", "Data"});
        }

        jsContDias.setModel(new SpinnerNumberModel(1,1,31,1));

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        jsContMes.setModel(new SpinnerListModel(meses));

        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

        jsContAnos.setModel(new SpinnerNumberModel(2024,2024,anoAtual + 100,1));

        atualizarTaela();

    }

    public void atualizarTaela(){

        try {

            Connection con = ConexaoAgenda.getConexao();

            String sql = "select *from dados_compromisso";

            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            model.setRowCount(0);


            while (rs.next()){

                model.addRow(new Object[]{rs.getString("comprimisso"), rs.getString("data")});

            }

            pst.close();
            con.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("Local de Agendamento");
        frame.setContentPane(new LocalDeAgendamento().panelAgendamento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }

}
