package provisionamento.view;

import Sistema.Dao;
import Sistema.FacadeCarregaArquivos;
import Sistema.Factoring;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Participante;
import provisionamento.model.Usuario;

public class Testes {

    public static void main(String[] args) {
        try {
            FacadeCarregaArquivos.Carrega();
            
            Dao<GrupoComunitario> daoG = Factoring.getDaoGrupoComunitario();
            Dao<Usuario> daoU = Factoring.getDaoUsuario();
            Dao<Participante> daoP = Factoring.getDaoParticipante();

            Usuario u;
            Usuario u1;
            Usuario u2;
            Usuario u3;
            Participante p1;
            Participante p2;
            Participante p3;
            GrupoComunitario g;
            for (int i = 0; i < 100; i++) {
                u = new Usuario();
                daoU.grava(u);
                u1 = new Usuario();
                daoU.grava(u1);
                u2 = new Usuario();
                daoU.grava(u2);
                u3 = new Usuario();
                daoU.grava(u3);

                p1 = new Participante();
                p1.setUsuario(u1);
                daoP.grava(p1);

                p2 = new Participante();
                p2.setUsuario(u2);
                daoP.grava(p2);

                p3 = new Participante();
                p3.setUsuario(u3);
                daoP.grava(p3);

                g = new GrupoComunitario();
                g.setCriador(u);
                g.addParticipante(p1);
                g.addParticipante(p2);
                g.addParticipante(p3);

                daoG.grava(g);
                
                System.out.println(i);
            }
            int i = 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
