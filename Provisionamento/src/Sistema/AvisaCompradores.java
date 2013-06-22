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
                GrupoComunitario grupo;
                Date dataAtual = new Date();

                while(it.hasNext()){
                    grupo = (GrupoComunitario) it.next();
                    if(grupo.getPrazoValidade() == dataAtual){
                        grupo.getComprador().getUsuario().setMensagem("Você precisa comprar mais " + grupo.getCategoria().getDescricao());
                    }
                }
                avisou = true;

            } catch (DaoException ex) {
                Logger.getLogger(AvisaCompradores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}