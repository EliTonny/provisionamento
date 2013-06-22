package provisionamento.view;

import Dao.Dao;
import DaoArquivo.DaoArquivoGrupoComunitario;
import DaoArquivo.DaoArquivoUsuario;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Usuario;

public class Testes {

    public static void main(String[] args) {
        try {          

             Dao<GrupoComunitario> daoG =
                     DaoArquivoGrupoComunitario.getInstancia();
             Dao<Usuario> daoU = 
                     DaoArquivoUsuario.getInstancia();
             
             Usuario u;
             GrupoComunitario g;
             for(int i = 0; i < 1000; i++)
             {
                u = new Usuario();
                daoU.grava(u);
                g = new GrupoComunitario();
                g.setCriador(u);
                daoG.grava(g);
                System.out.println(i);
             }
             
             for(GrupoComunitario gr : daoG.busca())
             {
                 daoG.deleta(gr);
             }

            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
