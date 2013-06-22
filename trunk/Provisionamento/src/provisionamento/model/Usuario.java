package provisionamento.model;

import DaoArquivo.ModeloBase;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends ModeloBase {

    private String nome;
    private String senha;
    private String email;
    private double salario;
    private List<Mensagem> mensagens;

    public Usuario(){
        this.mensagens = new ArrayList<>();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setMensagem(String mensagem){
        Mensagem novaMsg = new Mensagem(mensagem);
        this.mensagens.add(novaMsg);
    }
    
    public void removeMensagem(Mensagem mensagem){
        this.mensagens.remove(mensagem);
    }

    @Override
    public boolean equals(Object o) {
        Usuario usuario;
        if (o instanceof Usuario) {
            usuario = (Usuario) o;
            if (this.getId() == usuario.getId()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}
