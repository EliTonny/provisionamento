package provisionamento.fila;

import provisionamento.model.Usuario;

/**
 *
 * @author Eli T. de Souza
 */
public class UsuarioFila {
    private Usuario usuario;
    private UsuarioFila prox;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioFila getProx() {
        return prox;
    }

    public void setProx(UsuarioFila prox) {
        this.prox = prox;
    }

    public String toString(){
        return usuario.toString();
    }
}
