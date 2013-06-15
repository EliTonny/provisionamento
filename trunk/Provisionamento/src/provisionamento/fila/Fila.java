package provisionamento.fila;

import provisionamento.model.Usuario;

/**
 *
 * @author Eli T. de Souza
 */
public class Fila {
	private UsuarioFila ini;
	private UsuarioFila fim;

    public void insere(Usuario v){
        UsuarioFila novo = new UsuarioFila();
        novo.setUsuario(v);
        if (this.vazia()){
            this.ini = novo;
        } else {
            this.fim.setProx(novo);
        }
        this.fim = novo;
    }

    public Usuario retira() throws Exception {
        if (this.vazia()){
            throw new Exception("Fila vazia!");
        }
        UsuarioFila aux = this.ini;
        this.ini = this.ini.getProx();
        if (this.vazia())  // se agora ficou vazia
            this.fim = null;  // liberar o último objeto
        return aux.getUsuario();
    }

    public boolean vazia() {
        return (ini == null);
    }

    public void libera() {
        this.ini = null;
        this.fim = null;
    }
}
