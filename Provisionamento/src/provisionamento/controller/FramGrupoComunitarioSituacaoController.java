package provisionamento.controller;

import MyExceptions.DaoException;
import Sistema.Factoring;
import provisionamento.model.Participante;

public class FramGrupoComunitarioSituacaoController {
    public void AtualizarSituacaoParticipante(Participante p, boolean pago) throws DaoException
    {
        p.setPago(pago);
        Factoring.getDaoParticipante().grava(p);
    }
}
