
package provisionamento.model;

/**
 *
 * @author Eli T. de Souza
 */
public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String email;
    private double salario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    @Override
    public boolean equals(Object o){
        Usuario usuario;
        if(o instanceof Usuario){
            usuario = (Usuario) o;
            if(this.getId() == usuario.getId())
                return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
}
