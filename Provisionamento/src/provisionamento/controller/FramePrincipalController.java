package provisionamento.controller;

import MyExceptions.DaoException;
import Sistema.Dao;
import Sistema.Factoring;
import java.util.ArrayList;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.GrupoUnitario;
import provisionamento.model.Participante;
import provisionamento.model.Usuario;

public class FramePrincipalController {

    public ArrayList<GrupoComunitario> getGruposCriador(Usuario usu) throws DaoException {
        Dao<GrupoComunitario> daoG = Factoring.getDaoGrupoComunitario();
        ArrayList<GrupoComunitario> grupos = new ArrayList<>();
        for (GrupoComunitario g : daoG.busca()) {
            if (!g.isPago()) {
                if (g.getCriador().equals(usu)) {
                    grupos.add(g);
                }
            }
        }
        return grupos;
    }

    public ArrayList<GrupoUnitario> getGruposPessoais(Usuario usu) throws DaoException {
        Dao<GrupoUnitario> daoG = Factoring.getDaoGrupoUnitario();
        ArrayList<GrupoUnitario> grupos = new ArrayList<>();
        for (GrupoUnitario g : daoG.busca()) {
            if (!g.isFinalizado()) {
                if (g.getCriador().equals(usu)) {
                    grupos.add(g);
                }
            }
        }
        return grupos;
    }

    public ArrayList<GrupoComunitario> getGruposParticipante(Usuario usu) throws DaoException {
        Dao<GrupoComunitario> daoG = Factoring.getDaoGrupoComunitario();
        ArrayList<GrupoComunitario> grupos = new ArrayList<>();
        for (GrupoComunitario g : daoG.busca()) {
            if (!g.isPago()) {
                for (Participante p : g.getParticipantes()) {
                    if (p.getUsuario().equals(usu)) {
                        grupos.add(g);
                        break;
                    }
                }
            }
        }
        return grupos;
    }
}
