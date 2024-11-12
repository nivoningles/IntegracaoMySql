package Cadastro_De_Contatos;

import java.util.ArrayList;
import java.util.List;

public class ControleDeContatos {

    private List<String> nome = new ArrayList<>();
    private List<String> telefone = new ArrayList<>();
    private List<String> email = new ArrayList<>();

    public void contatos(String nome, String telefone, String email) {

        this.nome.add(nome);
        this.telefone.add(telefone);
        this.email.add(email);
    }

    public String getNome(int contador) {
        return nome.get(contador);
    }
    public String getTelefone(int contador) {
        return telefone.get(contador);
    }
    public String getEmail(int contador) {
        return email.get(contador);
    }

}
