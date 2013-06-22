package provisionamento.view;

import Sistema.Dao;
import Sistema.Factoring;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Usuario;

public class Testes {

    public static void main(String[] args) {
        try {
            //PODEM REMOVER SE QUIZER
            //ISSO AKI É PRA TESTAR SE TA GRAVANDO OS ARQUIVOS CORRETAMENTE
            //LOL
            //DAHORA
            Dao<GrupoComunitario> daoG = Factoring.getDaoGrupoComunitario();
            Dao<Usuario> daoU = Factoring.getDaoUsuario();

            Usuario u;
            GrupoComunitario g;
            for (int i = 0; i < 1000; i++) {
                u = new Usuario();
                daoU.grava(u);
                g = new GrupoComunitario();
                g.setCriador(u);
                daoG.grava(g);
                System.out.println(i);
            }

            for (GrupoComunitario gr : daoG.busca()) {
                daoG.deleta(gr);
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
