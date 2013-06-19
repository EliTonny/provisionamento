package provisionamento.view;

import Dao.Dao;
import java.util.Random;
import javax.swing.JOptionPane;
import provisionamento.DaoArquivo.DaoArquivoGrupoComunitario;
import provisionamento.DaoArquivo.DaoArquivoUsuario;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Usuario;

public class Testes {

    public static String[] letras = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
        "X", "Y", "Z"};

    public static void main(String[] args) {
        try {          

             Dao<GrupoComunitario> daoG =
                     DaoArquivoGrupoComunitario.getInstancia("D:\\Gustavo\\Documents\\ARQUIVOS");
             Dao<Usuario> daoU = 
                     DaoArquivoUsuario.getInstancia("D:\\Gustavo\\Documents\\ARQUIVOS");
             /*
             GrupoComunitario g = daoG.busca(0);
             Usuario u = daoU.busca(0);
             u.hashCode();
             
             g.getCriador().setNome("outro nome");
             
            String teste = "";
            teste += g.getCriador().getNome() + " - " + g.getCriador().hashCode() + "\n\r";
            teste += u.getNome() + " - " + u.hashCode();
            
            JOptionPane.showMessageDialog(null, teste);*/
            
            //daoG.busca()
            
             
             GrupoComunitario grupo = new GrupoComunitario();
             Usuario criador = new Usuario();
             criador.setNome("Gustavo S.");
             criador.setEmail("gustavo.sabel.gs@gmail.com");
             criador.setSalario(99999);
             criador.setSenha("senha");
             grupo.setCriador(criador);

             daoG.grava(grupo);
             daoU.grava(criador);

            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String geraString() {
        Random ran = new Random();

        String b = "";

        for (int i = 0; i < 4; i++) {
            int a = ran.nextInt(letras.length);
            b += letras[a];
        }

        return b;
    }
}
