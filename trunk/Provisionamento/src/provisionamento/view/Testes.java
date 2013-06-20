package provisionamento.view;

import Dao.Dao;
import java.util.Random;
import javax.swing.JOptionPane;
import provisionamento.DaoArquivo.DaoArquivoGrupoComunitario;
import provisionamento.DaoArquivo.DaoArquivoUsuario;
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
             for(int i = 0; i < 10; i++)
             {
                u = new Usuario();
                daoU.grava(u);
                System.out.println(i);
             }

            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
