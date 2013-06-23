package Sistema;

import MyExceptions.DaoException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import provisionamento.model.GrupoComunitario;

/**
 *
 * @author Eli T. de Souza
 */
public class AvisaCompradores {
    
    private AvisaCompradores(){
    }
    
    private static boolean avisou;
    
    public static void avisar(){
        if(avisou == false){
            try {
                Dao<GrupoComunitario> dao = Factoring.getDaoGrupoComunitario();
                List<GrupoComunitario> grupos = dao.busca();
                Iterator it = grupos.iterator();
                GrupoComunitario grupoComunitario;
                Date dataAtual = new Date(); 
                Date prazo = null;

                while(it.hasNext()){
                    grupoComunitario = (GrupoComunitario) it.next();
                    prazo.setTime(grupoComunitario.getPrazoValidade().getTime() - ((24 * 3600000) * (grupoComunitario.getQrdDiasNotificacao() + 1)));
                    if(dataAtual.after(prazo)){
                        grupoComunitario.getComprador().getUsuario().setMensagem("Você precisa comprar mais " + grupoComunitario.getCategoria().getDescricao());
                    }
                }
                
                avisou = true;

            } catch (DaoException ex) {
                Logger.getLogger(AvisaCompradores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}