package Sistema;

import MyExceptions.DaoException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Usuario;

/**
 *
 * @author Eli T. de Souza
 */
public class AvisaCompradores {
    
    private AvisaCompradores(){
    }
    
    public static void avisar(){
        
        try {
            Dao<GrupoComunitario> dao = Factoring.getDaoGrupoComunitario();
            List<GrupoComunitario> grupos = dao.busca();
            Iterator it = grupos.iterator();
            GrupoComunitario grupoComunitario;
            Date dataAtual = new Date(); 
            Date prazo = new Date();
            Session.getInstancia().getUsuarioLogado().removeMensagens();

            while(it.hasNext()){
                grupoComunitario = (GrupoComunitario) it.next();
                prazo.setTime(grupoComunitario.getPrazoValidade().getTime() - ((24 * 3600000) * (grupoComunitario.getQrdDiasNotificacao() + 1)));
                if(dataAtual.after(prazo)){
                    if(Session.getInstancia().getUsuarioLogado().equals(grupoComunitario.getComprador().getUsuario())){
                        Session.getInstancia().getUsuarioLogado().setMensagem("Você precisa comprar mais " + grupoComunitario.getCategoria().getDescricao());

                        /*Dao<Usuario> daoUsu = Factoring.getDaoUsuario();
                        daoUsu.grava(Session.getInstancia().getUsuarioLogado());*/
                    }
                }
            }

        } catch (DaoException ex) {
            Logger.getLogger(AvisaCompradores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}