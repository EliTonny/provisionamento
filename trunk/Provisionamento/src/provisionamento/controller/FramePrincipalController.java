package provisionamento.controller;

import MyExceptions.DaoException;
import Sistema.Dao;
import Sistema.Factoring;
import java.util.ArrayList;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Usuario;

public class FramePrincipalController {

    public ArrayList<GrupoComunitario> getGruposUsuario(Usuario usu) throws DaoException {
        Dao<GrupoComunitario> daoG = Factoring.getDaoGrupoComunitario();
        ArrayList<GrupoComunitario> grupos = new ArrayList<>();
        for (GrupoComunitario g : daoG.busca()) {
            if (g.getCriador().equals(usu)) {
                grupos.add(g);
            }
        }
        return grupos;
    }
}
