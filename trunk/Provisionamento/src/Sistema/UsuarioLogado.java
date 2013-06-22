package Sistema;

import provisionamento.model.Usuario;

/**
 *
 * @author Eli T. de Souza
 */
public class UsuarioLogado {
    private static Usuario usuario;
    
    private UsuarioLogado(){
    }    
    
    public static Usuario getUsuarioLogado(){
        return usuario;
    }
    
    public static void setUsuarioLogado(Usuario usuLog){
        usuario = usuLog;
    }
}
