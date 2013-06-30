package provisionamento.model;

import DaoArquivo.ModeloBase;

/**
 *
 * @author Eli T. de Souza
 */
public class Mensagem {
    private String mensagem;
    private GrupoUnitario grupo;
    
    public Mensagem(String mensagem, GrupoUnitario grupo){
        this.mensagem = mensagem;
        this.grupo = grupo;
    }
    
    public String getMensagem(){
        return this.mensagem;
    }

    public GrupoUnitario getGrupo() {
        return grupo;
    }
       
    @Override
    public String toString(){
        return this.mensagem;
    }
}
