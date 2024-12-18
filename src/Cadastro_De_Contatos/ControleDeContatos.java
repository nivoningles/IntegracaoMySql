package Cadastro_De_Contatos;

import Conexoes.ConexaoContatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleDeContatos {

    private List<String> nomes = new ArrayList<>();
    private List<String> telefones = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    public void contatos(String nome, String telefone, String email) {

        this.nomes.add(nome);
        this.telefones.add(telefone);
        this.emails.add(email);

        try {

            Connection con = ConexaoContatos.getConexao();

            String sql = "insert into dados_contatos (nome, telefone, email) values (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, telefone);
            stmt.setString(3, email);

            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void removeComprimisso(int indice) {

        if (indice >= 0 && indice < nomes.size()) {

            try {

                Connection con = ConexaoContatos.getConexao();

                String sql = "DELETE FROM dados_contatos WHERE nome = ? AND telefone = ? AND email = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nomes.get(indice));
                stmt.setString(2, telefones.get(indice));
                stmt.setString(3, emails.get(indice));

                stmt.execute();
                stmt.close();
                con.close();

                nomes.remove(indice);
                telefones.remove(indice);
                emails.remove(indice);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

    public void atualizarLista(){

        try {

            Connection con = ConexaoContatos.getConexao();

            String sql = "select * from dados_contatos";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                nomes.add(nome);
                telefones.add(telefone);
                emails.add(email);

            }

            rs.close();
            stmt.close();
            con.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public  String[] getnomesContatos() {
        return nomes.toArray(new String[0]);
    }

    public  String[] gettelefonesContatos() {
        return telefones.toArray(new String[0]);
    }

    public  String[] getemailsContatos() {
        return emails.toArray(new String[0]);
    }

}
