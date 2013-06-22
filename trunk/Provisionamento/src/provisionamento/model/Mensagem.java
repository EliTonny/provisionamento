package provisionamento.model;

import DaoArquivo.ModeloBase;

/**
 *
 * @author Eli T. de Souza
 */
public class Mensagem extends ModeloBase{
    private String mensagem;
    
    public Mensagem(String mensagem){
        this.mensagem = mensagem;
    }
    
    public String getMensagem(){
        return this.mensagem;
    }
}
