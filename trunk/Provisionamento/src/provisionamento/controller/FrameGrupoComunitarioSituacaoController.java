package provisionamento.controller;

import MyExceptions.DaoException;
import Sistema.Factoring;
import provisionamento.model.GrupoComunitario;
import provisionamento.model.Participante;

public class FrameGrupoComunitarioSituacaoController {
    public void AtualizarSituacaoParticipante(Participante p, boolean pago) throws DaoException
    {
        p.setPago(pago);
        Factoring.getDaoParticipante().grava(p);
    }
    public void PagarGrupo(GrupoComunitario grupo) throws DaoException
    {
        grupo.setPago(true);
        Factoring.getDaoGrupoComunitario().grava(grupo);
    }
}
