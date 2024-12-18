package Conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoAgenda {

    private static String caminho = "jdbc:mysql://localhost:3306/agenda?serverTimezone=America/Sao_Paulo";
    private static String usuario = "root";
    private static String senha = "devnivo1@";

    public static Connection getConexao() throws SQLException {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(caminho, usuario, senha);

        }catch (ClassNotFoundException e){
            throw new SQLException("Drive não encontrado: ");
        }


    }

}
