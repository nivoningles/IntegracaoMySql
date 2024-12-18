package AgendaDiaria;

import Conexoes.ConexaoAgenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalvadorDeAgendamento {

    private List<String> comprimisso = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private int contador = 0;

    public void salvador(String comprimisso, String dia, String mes, String ano) {

        this.comprimisso.add(comprimisso);
        this.data.add(dia + "/" + mes + "/" + ano);

        try {

            Connection con = ConexaoAgenda.getConexao();

            String sql = "insert into dados_compromisso(comprimisso, data) values (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, this.comprimisso.get(contador));
            stmt.setString(2, this.data.get(contador));

            contador++;

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String comprimisso(int contador){

        return comprimisso.get(contador);
    }

    public String data(int contador){

        return data.get(contador);
    }

}
